package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Value;

class ConversionInstance implements Instance {
    private final Context context;
    private final Class convert;
    private final Value value;

    public ConversionInstance(Context context2, Value value2, Class convert2) throws Exception {
        this.context = context2;
        this.convert = convert2;
        this.value = value2;
    }

    public Object getInstance() throws Exception {
        if (this.value.isReference()) {
            return this.value.getValue();
        }
        Object created = getInstance(this.convert);
        if (created != null) {
            setInstance(created);
        }
        return created;
    }

    public Object getInstance(Class type) throws Exception {
        return this.context.getInstance(type).getInstance();
    }

    public Object setInstance(Object object) throws Exception {
        Value value2 = this.value;
        if (value2 != null) {
            value2.setValue(object);
        }
        return object;
    }

    public Class getType() {
        return this.convert;
    }

    public boolean isReference() {
        return this.value.isReference();
    }
}
