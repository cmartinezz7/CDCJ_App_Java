package com.tealium.collect.listeners;

import com.tealium.collect.attribute.MetricAttribute;

public interface MetricUpdateListener extends CollectUpdateListener {
    void onMetricUpdate(MetricAttribute metricAttribute, MetricAttribute metricAttribute2);
}
