package com.tealium.collect.attribute;

public abstract class BaseAttribute {
    private final String a;

    public BaseAttribute(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("id must be provided.");
        }
        this.a = str;
    }

    public final String getId() {
        return this.a;
    }
}
