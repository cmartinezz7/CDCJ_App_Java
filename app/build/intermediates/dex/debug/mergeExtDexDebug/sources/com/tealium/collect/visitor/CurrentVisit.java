package com.tealium.collect.visitor;

import com.tealium.collect.attribute.DateAttribute;
import com.tealium.collect.attribute.FlagAttribute;
import com.tealium.collect.attribute.MetricAttribute;
import com.tealium.collect.attribute.PropertyAttribute;
import java.util.Collection;

public final class CurrentVisit extends a {
    private volatile int a;
    private final long b;
    private final int c;

    public CurrentVisit() {
        super(0, (Collection<DateAttribute>) null, (Collection<FlagAttribute>) null, (Collection<MetricAttribute>) null, (Collection<PropertyAttribute>) null);
        this.b = 0;
        this.c = 0;
    }

    public CurrentVisit(long j, Collection<DateAttribute> collection, Collection<FlagAttribute> collection2, Collection<MetricAttribute> collection3, Collection<PropertyAttribute> collection4, long j2, int i) {
        super(j, collection, collection2, collection3, collection4);
        this.b = j2;
        this.c = i;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof CurrentVisit)) {
            return false;
        }
        CurrentVisit currentVisit = (CurrentVisit) obj;
        return this.b == currentVisit.b && this.c == currentVisit.c && super.equals(currentVisit);
    }

    public long getLastEventTimestamp() {
        return this.b;
    }

    public int getTotalEventCount() {
        return this.c;
    }

    public int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        long j = this.b;
        int hashCode = ((((527 + super.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.c;
        this.a = hashCode;
        return hashCode;
    }

    public String toString() {
        return toString((String) null);
    }

    public String toString(String str) {
        if (str == null) {
            str = "";
        }
        String str2 = str.length() == 0 ? "    " : str + str;
        String property = System.getProperty("line.separator");
        return str + "CurrentVisit : {" + property + str2 + "creation_ts : " + getCreationTimestamp() + property + str2 + "last_event : " + this.b + property + str2 + "total_event_count : " + this.c + property + str2 + "dates : " + getDates().toString(str2) + property + str2 + "flags : " + getFlags().toString(str2) + property + str2 + "metrics : " + getMetrics().toString(str2) + property + str2 + "properties : " + getProperties().toString(str2) + property + str + "}";
    }
}
