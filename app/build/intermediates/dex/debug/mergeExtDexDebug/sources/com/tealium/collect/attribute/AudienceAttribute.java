package com.tealium.collect.attribute;

import java.util.Locale;
import org.json.JSONObject;

public final class AudienceAttribute extends BaseAttribute {
    private final String a;
    private volatile int b;

    public AudienceAttribute(String str, String str2) {
        super(str);
        if (str2 == null || str2.length() == 0) {
            throw new IllegalArgumentException("name must be provided.");
        }
        this.a = str2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !AudienceAttribute.class.equals(obj.getClass())) {
            return false;
        }
        AudienceAttribute audienceAttribute = (AudienceAttribute) obj;
        return getId().equals(audienceAttribute.getId()) && this.a.equals(audienceAttribute.a);
    }

    public String getName() {
        return this.a;
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int hashCode = ((527 + getId().hashCode()) * 31) + this.a.hashCode();
        this.b = hashCode;
        return hashCode;
    }

    public String toString() {
        return String.format(Locale.ROOT, "Audience : { id:%s, name:%s }", new Object[]{JSONObject.quote(getId()), JSONObject.quote(this.a)});
    }
}
