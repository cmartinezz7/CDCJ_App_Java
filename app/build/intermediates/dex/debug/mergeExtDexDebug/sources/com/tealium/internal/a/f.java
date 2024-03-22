package com.tealium.internal.a;

import com.tealium.collect.attribute.AttributeGroup;
import com.tealium.collect.attribute.MetricAttribute;
import com.tealium.collect.listeners.MetricUpdateListener;

final class f extends a<MetricUpdateListener, MetricAttribute> {
    public f(AttributeGroup<MetricAttribute> attributeGroup, AttributeGroup<MetricAttribute> attributeGroup2) {
        super(MetricUpdateListener.class, attributeGroup, attributeGroup2);
    }

    public void a(MetricUpdateListener metricUpdateListener) {
        if (c() != null) {
            for (MetricAttribute onMetricUpdate : c()) {
                metricUpdateListener.onMetricUpdate(onMetricUpdate, (MetricAttribute) null);
            }
        }
        if (e() != null) {
            for (MetricAttribute metricAttribute : e()) {
                metricUpdateListener.onMetricUpdate((MetricAttribute) b().get(metricAttribute.getId()), metricAttribute);
            }
        }
        if (d() != null) {
            for (MetricAttribute onMetricUpdate2 : d()) {
                metricUpdateListener.onMetricUpdate((MetricAttribute) null, onMetricUpdate2);
            }
        }
    }
}
