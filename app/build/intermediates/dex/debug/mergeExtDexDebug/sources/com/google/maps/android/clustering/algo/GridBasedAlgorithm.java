package com.google.maps.android.clustering.algo;

import androidx.collection.LongSparseArray;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GridBasedAlgorithm<T extends ClusterItem> implements Algorithm<T> {
    private static final int GRID_SIZE = 100;
    private final Set<T> mItems = Collections.synchronizedSet(new HashSet());

    public void addItem(T item) {
        this.mItems.add(item);
    }

    public void addItems(Collection<T> items) {
        this.mItems.addAll(items);
    }

    public void clearItems() {
        this.mItems.clear();
    }

    public void removeItem(T item) {
        this.mItems.remove(item);
    }

    public Set<? extends Cluster<T>> getClusters(double zoom) {
        long numCells;
        long numCells2 = (long) Math.ceil((Math.pow(2.0d, zoom) * 256.0d) / 100.0d);
        SphericalMercatorProjection proj = new SphericalMercatorProjection((double) numCells2);
        HashSet<Cluster<T>> clusters = new HashSet<>();
        LongSparseArray longSparseArray = new LongSparseArray();
        synchronized (this.mItems) {
            try {
                T item = this.mItems.iterator();
                while (item.hasNext()) {
                    ClusterItem clusterItem = (ClusterItem) item.next();
                    Point p = proj.toPoint(clusterItem.getPosition());
                    T t = item;
                    ClusterItem clusterItem2 = clusterItem;
                    Point p2 = p;
                    long coord = getCoord(numCells2, p.x, p.y);
                    StaticCluster<T> cluster = (StaticCluster) longSparseArray.get(coord);
                    if (cluster == null) {
                        numCells = numCells2;
                        cluster = new StaticCluster<>(proj.toLatLng(new Point(Math.floor(p2.x) + 0.5d, Math.floor(p2.y) + 0.5d)));
                        longSparseArray.put(coord, cluster);
                        clusters.add(cluster);
                    } else {
                        numCells = numCells2;
                    }
                    cluster.add(clusterItem2);
                    double d = zoom;
                    numCells2 = numCells;
                    item = t;
                }
                return clusters;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    public Collection<T> getItems() {
        return this.mItems;
    }

    private static long getCoord(long numCells, double x, double y) {
        return (long) ((((double) numCells) * Math.floor(x)) + Math.floor(y));
    }
}
