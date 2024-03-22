package com.google.maps.android.clustering;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.MarkerManager;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.algo.Algorithm;
import com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.google.maps.android.clustering.algo.PreCachingAlgorithmDecorator;
import com.google.maps.android.clustering.view.ClusterRenderer;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ClusterManager<T extends ClusterItem> implements GoogleMap.OnCameraIdleListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener {
    /* access modifiers changed from: private */
    public Algorithm<T> mAlgorithm;
    /* access modifiers changed from: private */
    public final ReadWriteLock mAlgorithmLock;
    private final MarkerManager.Collection mClusterMarkers;
    private ClusterManager<T>.ClusterTask mClusterTask;
    private final ReadWriteLock mClusterTaskLock;
    private GoogleMap mMap;
    private final MarkerManager mMarkerManager;
    private final MarkerManager.Collection mMarkers;
    private OnClusterClickListener<T> mOnClusterClickListener;
    private OnClusterInfoWindowClickListener<T> mOnClusterInfoWindowClickListener;
    private OnClusterItemClickListener<T> mOnClusterItemClickListener;
    private OnClusterItemInfoWindowClickListener<T> mOnClusterItemInfoWindowClickListener;
    private CameraPosition mPreviousCameraPosition;
    /* access modifiers changed from: private */
    public ClusterRenderer<T> mRenderer;

    public interface OnClusterClickListener<T extends ClusterItem> {
        boolean onClusterClick(Cluster<T> cluster);
    }

    public interface OnClusterInfoWindowClickListener<T extends ClusterItem> {
        void onClusterInfoWindowClick(Cluster<T> cluster);
    }

    public interface OnClusterItemClickListener<T extends ClusterItem> {
        boolean onClusterItemClick(T t);
    }

    public interface OnClusterItemInfoWindowClickListener<T extends ClusterItem> {
        void onClusterItemInfoWindowClick(T t);
    }

    public ClusterManager(Context context, GoogleMap map) {
        this(context, map, new MarkerManager(map));
    }

    public ClusterManager(Context context, GoogleMap map, MarkerManager markerManager) {
        this.mAlgorithmLock = new ReentrantReadWriteLock();
        this.mClusterTaskLock = new ReentrantReadWriteLock();
        this.mMap = map;
        this.mMarkerManager = markerManager;
        this.mClusterMarkers = markerManager.newCollection();
        this.mMarkers = markerManager.newCollection();
        this.mRenderer = new DefaultClusterRenderer(context, map, this);
        this.mAlgorithm = new PreCachingAlgorithmDecorator(new NonHierarchicalDistanceBasedAlgorithm());
        this.mClusterTask = new ClusterTask();
        this.mRenderer.onAdd();
    }

    public MarkerManager.Collection getMarkerCollection() {
        return this.mMarkers;
    }

    public MarkerManager.Collection getClusterMarkerCollection() {
        return this.mClusterMarkers;
    }

    public MarkerManager getMarkerManager() {
        return this.mMarkerManager;
    }

    public void setRenderer(ClusterRenderer<T> view) {
        this.mRenderer.setOnClusterClickListener((OnClusterClickListener) null);
        this.mRenderer.setOnClusterItemClickListener((OnClusterItemClickListener) null);
        this.mClusterMarkers.clear();
        this.mMarkers.clear();
        this.mRenderer.onRemove();
        this.mRenderer = view;
        view.onAdd();
        this.mRenderer.setOnClusterClickListener(this.mOnClusterClickListener);
        this.mRenderer.setOnClusterInfoWindowClickListener(this.mOnClusterInfoWindowClickListener);
        this.mRenderer.setOnClusterItemClickListener(this.mOnClusterItemClickListener);
        this.mRenderer.setOnClusterItemInfoWindowClickListener(this.mOnClusterItemInfoWindowClickListener);
        cluster();
    }

    /* JADX INFO: finally extract failed */
    public void setAlgorithm(Algorithm<T> algorithm) {
        this.mAlgorithmLock.writeLock().lock();
        try {
            Algorithm<T> algorithm2 = this.mAlgorithm;
            if (algorithm2 != null) {
                algorithm.addItems(algorithm2.getItems());
            }
            this.mAlgorithm = new PreCachingAlgorithmDecorator(algorithm);
            this.mAlgorithmLock.writeLock().unlock();
            cluster();
        } catch (Throwable th) {
            this.mAlgorithmLock.writeLock().unlock();
            throw th;
        }
    }

    public void setAnimation(boolean animate) {
        this.mRenderer.setAnimation(animate);
    }

    public ClusterRenderer<T> getRenderer() {
        return this.mRenderer;
    }

    public Algorithm<T> getAlgorithm() {
        return this.mAlgorithm;
    }

    public void clearItems() {
        this.mAlgorithmLock.writeLock().lock();
        try {
            this.mAlgorithm.clearItems();
        } finally {
            this.mAlgorithmLock.writeLock().unlock();
        }
    }

    public void addItems(Collection<T> items) {
        this.mAlgorithmLock.writeLock().lock();
        try {
            this.mAlgorithm.addItems(items);
        } finally {
            this.mAlgorithmLock.writeLock().unlock();
        }
    }

    public void addItem(T myItem) {
        this.mAlgorithmLock.writeLock().lock();
        try {
            this.mAlgorithm.addItem(myItem);
        } finally {
            this.mAlgorithmLock.writeLock().unlock();
        }
    }

    public void removeItem(T item) {
        this.mAlgorithmLock.writeLock().lock();
        try {
            this.mAlgorithm.removeItem(item);
        } finally {
            this.mAlgorithmLock.writeLock().unlock();
        }
    }

    public void cluster() {
        this.mClusterTaskLock.writeLock().lock();
        try {
            this.mClusterTask.cancel(true);
            this.mClusterTask = new ClusterTask();
            if (Build.VERSION.SDK_INT < 11) {
                this.mClusterTask.execute(new Float[]{Float.valueOf(this.mMap.getCameraPosition().zoom)});
            } else {
                this.mClusterTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Float[]{Float.valueOf(this.mMap.getCameraPosition().zoom)});
            }
        } finally {
            this.mClusterTaskLock.writeLock().unlock();
        }
    }

    public void onCameraIdle() {
        GoogleMap.OnCameraIdleListener onCameraIdleListener = this.mRenderer;
        if (onCameraIdleListener instanceof GoogleMap.OnCameraIdleListener) {
            onCameraIdleListener.onCameraIdle();
        }
        CameraPosition position = this.mMap.getCameraPosition();
        CameraPosition cameraPosition = this.mPreviousCameraPosition;
        if (cameraPosition == null || cameraPosition.zoom != position.zoom) {
            this.mPreviousCameraPosition = this.mMap.getCameraPosition();
            cluster();
        }
    }

    public boolean onMarkerClick(Marker marker) {
        return getMarkerManager().onMarkerClick(marker);
    }

    public void onInfoWindowClick(Marker marker) {
        getMarkerManager().onInfoWindowClick(marker);
    }

    private class ClusterTask extends AsyncTask<Float, Void, Set<? extends Cluster<T>>> {
        private ClusterTask() {
        }

        /* access modifiers changed from: protected */
        public Set<? extends Cluster<T>> doInBackground(Float... zoom) {
            ClusterManager.this.mAlgorithmLock.readLock().lock();
            try {
                return ClusterManager.this.mAlgorithm.getClusters((double) zoom[0].floatValue());
            } finally {
                ClusterManager.this.mAlgorithmLock.readLock().unlock();
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Set<? extends Cluster<T>> clusters) {
            ClusterManager.this.mRenderer.onClustersChanged(clusters);
        }
    }

    public void setOnClusterClickListener(OnClusterClickListener<T> listener) {
        this.mOnClusterClickListener = listener;
        this.mRenderer.setOnClusterClickListener(listener);
    }

    public void setOnClusterInfoWindowClickListener(OnClusterInfoWindowClickListener<T> listener) {
        this.mOnClusterInfoWindowClickListener = listener;
        this.mRenderer.setOnClusterInfoWindowClickListener(listener);
    }

    public void setOnClusterItemClickListener(OnClusterItemClickListener<T> listener) {
        this.mOnClusterItemClickListener = listener;
        this.mRenderer.setOnClusterItemClickListener(listener);
    }

    public void setOnClusterItemInfoWindowClickListener(OnClusterItemInfoWindowClickListener<T> listener) {
        this.mOnClusterItemInfoWindowClickListener = listener;
        this.mRenderer.setOnClusterItemInfoWindowClickListener(listener);
    }
}
