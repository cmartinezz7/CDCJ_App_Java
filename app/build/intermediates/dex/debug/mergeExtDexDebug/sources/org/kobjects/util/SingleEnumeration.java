package org.kobjects.util;

import java.util.Enumeration;

public class SingleEnumeration implements Enumeration {
    Object object;

    public SingleEnumeration(Object object2) {
        this.object = object2;
    }

    public boolean hasMoreElements() {
        return this.object != null;
    }

    public Object nextElement() {
        Object result = this.object;
        this.object = null;
        return result;
    }
}
