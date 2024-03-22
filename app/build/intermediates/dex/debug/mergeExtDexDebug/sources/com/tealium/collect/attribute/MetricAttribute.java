package com.tealium.collect.attribute;

import java.util.Locale;
import org.json.JSONObject;

public class MetricAttribute extends BaseAttribute {
    private final double a;
    private volatile int b;

    public MetricAttribute(String str, double d) {
        super(str);
        this.a = d;
    }

    public boolean equals(Object obj) {
        if (obj == null || !MetricAttribute.class.equals(obj.getClass())) {
            return false;
        }
        MetricAttribute metricAttribute = (MetricAttribute) obj;
        return getId().equals(metricAttribute.getId()) && this.a == metricAttribute.a;
    }

    public double getValue() {
        return this.a;
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        long doubleToLongBits = Double.doubleToLongBits(this.a);
        int hashCode = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + ((527 + getId().hashCode()) * 31);
        this.b = hashCode;
        return hashCode;
    }

    public String toString() {
        return String.format(Locale.ROOT, "Metric : { id:%s, value:%f }", new Object[]{JSONObject.quote(getId()), Double.valueOf(this.a)});
    }
}
