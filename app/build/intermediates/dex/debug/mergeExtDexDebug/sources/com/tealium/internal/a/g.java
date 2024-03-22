package com.tealium.internal.a;

import com.tealium.collect.attribute.AttributeGroup;
import com.tealium.collect.attribute.PropertyAttribute;
import com.tealium.collect.listeners.PropertyUpdateListener;

final class g extends a<PropertyUpdateListener, PropertyAttribute> {
    public g(AttributeGroup<PropertyAttribute> attributeGroup, AttributeGroup<PropertyAttribute> attributeGroup2) {
        super(PropertyUpdateListener.class, attributeGroup, attributeGroup2);
    }

    public void a(PropertyUpdateListener propertyUpdateListener) {
        if (c() != null) {
            for (PropertyAttribute onPropertyUpdate : c()) {
                propertyUpdateListener.onPropertyUpdate(onPropertyUpdate, (PropertyAttribute) null);
            }
        }
        if (e() != null) {
            for (PropertyAttribute propertyAttribute : e()) {
                propertyUpdateListener.onPropertyUpdate((PropertyAttribute) b().get(propertyAttribute.getId()), propertyAttribute);
            }
        }
        if (d() != null) {
            for (PropertyAttribute onPropertyUpdate2 : d()) {
                propertyUpdateListener.onPropertyUpdate((PropertyAttribute) null, onPropertyUpdate2);
            }
        }
    }
}
