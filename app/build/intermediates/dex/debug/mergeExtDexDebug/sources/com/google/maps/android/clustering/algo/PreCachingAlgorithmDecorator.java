package com.google.maps.android.clustering.algo;

import androidx.collection.LruCache;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PreCachingAlgorithmDecorator<T extends ClusterItem> implements Algorithm<T> {
    private final Algorithm<T> mAlgorithm;
    private final LruCache<Integer, Set<? extends Cluster<T>>> mCache = new LruCache<>(5);
    private final ReadWriteLock mCacheLock = new ReentrantReadWriteLock();

    public PreCachingAlgorithmDecorator(Algorithm<T> algorithm) {
        this.mAlgorithm = algorithm;
    }

    public void addItem(T item) {
        this.mAlgorithm.addItem(item);
        clearCache();
    }

    public void addItems(Collection<T> items) {
        this.mAlgorithm.addItems(items);
        clearCache();
    }

    public void clearItems() {
        this.mAlgorithm.clearItems();
        clearCache();
    }

    public void removeItem(T item) {
        this.mAlgorithm.removeItem(item);
        clearCache();
    }

    private void clearCache() {
        this.mCache.evictAll();
    }

    public Set<? extends Cluster<T>> getClusters(double zoom) {
        int discreteZoom = (int) zoom;
        Set<? extends Cluster<T>> results = getClustersInternal(discreteZoom);
        if (this.mCache.get(Integer.valueOf(discreteZoom + 1)) == null) {
            new Thread(new PrecacheRunnable(discreteZoom + 1)).start();
        }
        if (this.mCache.get(Integer.valueOf(discreteZoom - 1)) == null) {
            new Thread(new PrecacheRunnable(discreteZoom - 1)).start();
        }
        return results;
    }

    public Collection<T> getItems() {
        return this.mAlgorithm.getItems();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.util.Set<? extends com.google.maps.android.clustering.Cluster<T>>} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Set<? extends com.google.maps.android.clustering.Cluster<T>> getClustersInternal(int r5) {
        /*
            r4 = this;
            java.util.concurrent.locks.ReadWriteLock r0 = r4.mCacheLock
            java.util.concurrent.locks.Lock r0 = r0.readLock()
            r0.lock()
            androidx.collection.LruCache<java.lang.Integer, java.util.Set<? extends com.google.maps.android.clustering.Cluster<T>>> r0 = r4.mCache
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r0.get(r1)
            java.util.Set r0 = (java.util.Set) r0
            java.util.concurrent.locks.ReadWriteLock r1 = r4.mCacheLock
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            if (r0 != 0) goto L_0x0051
            java.util.concurrent.locks.ReadWriteLock r1 = r4.mCacheLock
            java.util.concurrent.locks.Lock r1 = r1.writeLock()
            r1.lock()
            androidx.collection.LruCache<java.lang.Integer, java.util.Set<? extends com.google.maps.android.clustering.Cluster<T>>> r1 = r4.mCache
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            java.lang.Object r1 = r1.get(r2)
            r0 = r1
            java.util.Set r0 = (java.util.Set) r0
            if (r0 != 0) goto L_0x0048
            com.google.maps.android.clustering.algo.Algorithm<T> r1 = r4.mAlgorithm
            double r2 = (double) r5
            java.util.Set r0 = r1.getClusters(r2)
            androidx.collection.LruCache<java.lang.Integer, java.util.Set<? extends com.google.maps.android.clustering.Cluster<T>>> r1 = r4.mCache
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            r1.put(r2, r0)
        L_0x0048:
            java.util.concurrent.locks.ReadWriteLock r1 = r4.mCacheLock
            java.util.concurrent.locks.Lock r1 = r1.writeLock()
            r1.unlock()
        L_0x0051:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.clustering.algo.PreCachingAlgorithmDecorator.getClustersInternal(int):java.util.Set");
    }

    private class PrecacheRunnable implements Runnable {
        private final int mZoom;

        public PrecacheRunnable(int zoom) {
            this.mZoom = zoom;
        }

        public void run() {
            try {
                Thread.sleep((long) ((Math.random() * 500.0d) + 500.0d));
            } catch (InterruptedException e) {
            }
            Set unused = PreCachingAlgorithmDecorator.this.getClustersInternal(this.mZoom);
        }
    }
}
