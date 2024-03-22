package com.tealium.collect.attribute;

import java.util.Locale;
import org.json.JSONObject;

public final class BadgeAttribute extends BaseAttribute {
    private volatile int a = 0;

    public BadgeAttribute(String str) {
        super(str);
    }

    public boolean equals(Object obj) {
        if (obj != null && BadgeAttribute.class.equals(obj.getClass())) {
            return getId().equals(((BadgeAttribute) obj).getId());
        }
        return false;
    }

    public int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        int hashCode = 527 + getId().hashCode();
        this.a = hashCode;
        return hashCode;
    }

    public String toString() {
        return String.format(Locale.ROOT, "Badge : { id:%s }", new Object[]{JSONObject.quote(getId())});
    }
}
