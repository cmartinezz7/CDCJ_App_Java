package com.tealium.collect.attribute;

import java.util.Locale;
import org.json.JSONObject;

public class PropertyAttribute extends BaseAttribute {
    private final String a;
    private volatile int b;

    public PropertyAttribute(String str, String str2) {
        super(str);
        this.a = str2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !PropertyAttribute.class.equals(obj.getClass())) {
            return false;
        }
        PropertyAttribute propertyAttribute = (PropertyAttribute) obj;
        if (!getId().equals(propertyAttribute.getId())) {
            return false;
        }
        String str = this.a;
        boolean z = str == null;
        String str2 = propertyAttribute.a;
        boolean z2 = str2 == null;
        if (z && z2) {
            return true;
        }
        if (z ^ z2) {
            return false;
        }
        return str.equals(str2);
    }

    public String getValue() {
        return this.a;
    }

    public int hashCode() {
        int i = this.b;
        if (i == 0) {
            i = 527 + getId().hashCode();
            String str = this.a;
            if (str != null) {
                i = (i * 31) + str.hashCode();
            }
            this.b = i;
        }
        return i;
    }

    public String toString() {
        return String.format(Locale.ROOT, "Property : { id:%s, value:%s }", new Object[]{JSONObject.quote(getId()), JSONObject.quote(this.a)});
    }
}
