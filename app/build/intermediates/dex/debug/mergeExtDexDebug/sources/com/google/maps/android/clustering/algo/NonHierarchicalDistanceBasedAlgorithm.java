package com.google.maps.android.clustering.algo;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import com.google.maps.android.quadtree.PointQuadTree;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NonHierarchicalDistanceBasedAlgorithm<T extends ClusterItem> implements Algorithm<T> {
    public static final int MAX_DISTANCE_AT_ZOOM = 100;
    /* access modifiers changed from: private */
    public static final SphericalMercatorProjection PROJECTION = new SphericalMercatorProjection(1.0d);
    private final Collection<QuadItem<T>> mItems = new ArrayList();
    private final PointQuadTree<QuadItem<T>> mQuadTree = new PointQuadTree(0.0d, 1.0d, 0.0d, 1.0d);

    public void addItem(T item) {
        QuadItem<T> quadItem = new QuadItem<>(item);
        synchronized (this.mQuadTree) {
            this.mItems.add(quadItem);
            this.mQuadTree.add(quadItem);
        }
    }

    public void addItems(Collection<T> items) {
        for (T item : items) {
            addItem(item);
        }
    }

    public void clearItems() {
        synchronized (this.mQuadTree) {
            this.mItems.clear();
            this.mQuadTree.clear();
        }
    }

    public void removeItem(T item) {
        QuadItem<T> quadItem = new QuadItem<>(item);
        synchronized (this.mQuadTree) {
            this.mItems.remove(quadItem);
            this.mQuadTree.remove(quadItem);
        }
    }

    public Set<? extends Cluster<T>> getClusters(double zoom) {
        NonHierarchicalDistanceBasedAlgorithm nonHierarchicalDistanceBasedAlgorithm = this;
        int discreteZoom = (int) zoom;
        double distance = (100.0d / Math.pow(2.0d, (double) discreteZoom)) / 256.0d;
        Set<QuadItem<T>> visitedCandidates = new HashSet<>();
        Set<Cluster<T>> results = new HashSet<>();
        Map<QuadItem<T>, Double> distanceToCluster = new HashMap<>();
        Map<QuadItem<T>, StaticCluster<T>> itemToCluster = new HashMap<>();
        synchronized (nonHierarchicalDistanceBasedAlgorithm.mQuadTree) {
            try {
                Iterator<QuadItem<T>> it = nonHierarchicalDistanceBasedAlgorithm.mItems.iterator();
                while (it.hasNext()) {
                    QuadItem<T> candidate = it.next();
                    if (!visitedCandidates.contains(candidate)) {
                        Collection<QuadItem<T>> clusterItems = nonHierarchicalDistanceBasedAlgorithm.mQuadTree.search(nonHierarchicalDistanceBasedAlgorithm.createBoundsFromSpan(candidate.getPoint(), distance));
                        Iterator<QuadItem<T>> it2 = it;
                        if (clusterItems.size() == 1) {
                            try {
                                results.add(candidate);
                                visitedCandidates.add(candidate);
                                distanceToCluster.put(candidate, Double.valueOf(0.0d));
                                it = it2;
                            } catch (Throwable th) {
                                th = th;
                                int i = discreteZoom;
                                double d = distance;
                                throw th;
                            }
                        } else {
                            StaticCluster<T> cluster = new StaticCluster<>(candidate.mClusterItem.getPosition());
                            results.add(cluster);
                            for (QuadItem next : clusterItems) {
                                Double existingDistance = distanceToCluster.get(next);
                                int discreteZoom2 = discreteZoom;
                                try {
                                    double zoomSpecificSpan = distance;
                                    double distance2 = nonHierarchicalDistanceBasedAlgorithm.distanceSquared(next.getPoint(), candidate.getPoint());
                                    if (existingDistance != null) {
                                        if (existingDistance.doubleValue() < distance2) {
                                            double d2 = zoom;
                                            discreteZoom = discreteZoom2;
                                            distance = zoomSpecificSpan;
                                        } else {
                                            itemToCluster.get(next).remove(next.mClusterItem);
                                        }
                                    }
                                    distanceToCluster.put(next, Double.valueOf(distance2));
                                    cluster.add(next.mClusterItem);
                                    itemToCluster.put(next, cluster);
                                    nonHierarchicalDistanceBasedAlgorithm = this;
                                    double d3 = zoom;
                                    discreteZoom = discreteZoom2;
                                    distance = zoomSpecificSpan;
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            }
                            visitedCandidates.addAll(clusterItems);
                            nonHierarchicalDistanceBasedAlgorithm = this;
                            double d4 = zoom;
                            it = it2;
                            discreteZoom = discreteZoom;
                            distance = distance;
                        }
                    }
                }
                double d5 = distance;
                return results;
            } catch (Throwable th3) {
                th = th3;
                int i2 = discreteZoom;
                double d6 = distance;
                throw th;
            }
        }
    }

    public Collection<T> getItems() {
        List<T> items = new ArrayList<>();
        synchronized (this.mQuadTree) {
            for (QuadItem<T> quadItem : this.mItems) {
                items.add(quadItem.mClusterItem);
            }
        }
        return items;
    }

    private double distanceSquared(Point a, Point b) {
        return ((a.x - b.x) * (a.x - b.x)) + ((a.y - b.y) * (a.y - b.y));
    }

    private Bounds createBoundsFromSpan(Point p, double span) {
        double halfSpan = span / 2.0d;
        return new Bounds(p.x - halfSpan, p.x + halfSpan, p.y - halfSpan, p.y + halfSpan);
    }

    private static class QuadItem<T extends ClusterItem> implements PointQuadTree.Item, Cluster<T> {
        /* access modifiers changed from: private */
        public final T mClusterItem;
        private final Point mPoint;
        private final LatLng mPosition;
        private Set<T> singletonSet;

        private QuadItem(T item) {
            this.mClusterItem = item;
            LatLng position = item.getPosition();
            this.mPosition = position;
            this.mPoint = NonHierarchicalDistanceBasedAlgorithm.PROJECTION.toPoint(position);
            this.singletonSet = Collections.singleton(item);
        }

        public Point getPoint() {
            return this.mPoint;
        }

        public LatLng getPosition() {
            return this.mPosition;
        }

        public Set<T> getItems() {
            return this.singletonSet;
        }

        public int getSize() {
            return 1;
        }

        public int hashCode() {
            return this.mClusterItem.hashCode();
        }

        public boolean equals(Object other) {
            if (!(other instanceof QuadItem)) {
                return false;
            }
            return ((QuadItem) other).mClusterItem.equals(this.mClusterItem);
        }
    }
}
