package com.tealium.collect.attribute;

import java.util.Locale;
import org.json.JSONObject;

public final class FlagAttribute extends BaseAttribute {
    private final boolean a;
    private volatile int b = 0;

    public FlagAttribute(String str, boolean z) {
        super(str);
        this.a = z;
    }

    public boolean equals(Object obj) {
        if (obj == null || !FlagAttribute.class.equals(obj.getClass())) {
            return false;
        }
        FlagAttribute flagAttribute = (FlagAttribute) obj;
        return getId().equals(flagAttribute.getId()) && this.a == flagAttribute.a;
    }

    public boolean getValue() {
        return this.a;
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int hashCode = ((527 + getId().hashCode()) * 31) + (this.a ? 1 : 0);
        this.b = hashCode;
        return hashCode;
    }

    public String toString() {
        return String.format(Locale.ROOT, "Flag : { id:%s, value:%b }", new Object[]{JSONObject.quote(getId()), Boolean.valueOf(this.a)});
    }
}
