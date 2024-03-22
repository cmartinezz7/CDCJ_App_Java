package org.simpleframework.xml.core;

import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.strategy.Type;

class Entry {
    private static final String DEFAULT_NAME = "entry";
    private boolean attribute;
    private Contact contact;
    private String entry;
    private String key;
    private Class keyType;
    private ElementMap label;
    private String value;
    private Class valueType;

    public Entry(Contact contact2, ElementMap label2) {
        this.attribute = label2.attribute();
        this.entry = label2.entry();
        this.value = label2.value();
        this.key = label2.key();
        this.contact = contact2;
        this.label = label2;
    }

    public Contact getContact() {
        return this.contact;
    }

    public boolean isAttribute() {
        return this.attribute;
    }

    public boolean isInline() throws Exception {
        return isAttribute();
    }

    public Converter getKey(Context context) throws Exception {
        Type type = getKeyType();
        if (context.isPrimitive(type)) {
            return new PrimitiveKey(context, this, type);
        }
        return new CompositeKey(context, this, type);
    }

    public Converter getValue(Context context) throws Exception {
        Type type = getValueType();
        if (context.isPrimitive(type)) {
            return new PrimitiveValue(context, this, type);
        }
        return new CompositeValue(context, this, type);
    }

    /* access modifiers changed from: protected */
    public Type getKeyType() throws Exception {
        if (this.keyType == null) {
            Class keyType2 = this.label.keyType();
            this.keyType = keyType2;
            if (keyType2 == Void.TYPE) {
                this.keyType = getDependent(0);
            }
        }
        return new ClassType(this.keyType);
    }

    /* access modifiers changed from: protected */
    public Type getValueType() throws Exception {
        if (this.valueType == null) {
            Class valueType2 = this.label.valueType();
            this.valueType = valueType2;
            if (valueType2 == Void.TYPE) {
                this.valueType = getDependent(1);
            }
        }
        return new ClassType(this.valueType);
    }

    private Class getDependent(int index) throws Exception {
        Class[] list = this.contact.getDependents();
        if (list.length >= index && list.length != 0) {
            return list[index];
        }
        return Object.class;
    }

    public String getKey() throws Exception {
        String str = this.key;
        if (str == null) {
            return str;
        }
        if (isEmpty(str)) {
            this.key = null;
        }
        return this.key;
    }

    public String getValue() throws Exception {
        String str = this.value;
        if (str == null) {
            return str;
        }
        if (isEmpty(str)) {
            this.value = null;
        }
        return this.value;
    }

    public String getEntry() throws Exception {
        String str = this.entry;
        if (str == null) {
            return str;
        }
        if (isEmpty(str)) {
            this.entry = DEFAULT_NAME;
        }
        return this.entry;
    }

    private boolean isEmpty(String value2) {
        return value2.length() == 0;
    }

    public String toString() {
        return String.format("%s on %s", new Object[]{this.label, this.contact});
    }
}
