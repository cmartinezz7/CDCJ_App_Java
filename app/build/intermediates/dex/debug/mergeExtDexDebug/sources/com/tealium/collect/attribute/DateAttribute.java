package com.tealium.collect.attribute;

import java.util.Locale;
import org.json.JSONObject;

public final class DateAttribute extends BaseAttribute {
    private final long a;
    private volatile int b;

    public DateAttribute(String str, long j) {
        super(str);
        this.a = j;
    }

    public boolean equals(Object obj) {
        if (obj == null || !DateAttribute.class.equals(obj.getClass())) {
            return false;
        }
        DateAttribute dateAttribute = (DateAttribute) obj;
        return getId().equals(dateAttribute.getId()) && this.a == dateAttribute.a;
    }

    public long getTime() {
        return this.a;
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        long j = this.a;
        int hashCode = ((527 + getId().hashCode()) * 31) + ((int) (j ^ (j >>> 32)));
        this.b = hashCode;
        return hashCode;
    }

    public String toString() {
        return String.format(Locale.ROOT, "Date : { id:%s, timestamp_ms:%d }", new Object[]{JSONObject.quote(getId()), Long.valueOf(this.a)});
    }
}
