package com.tealium.collect.listeners;

import com.tealium.collect.attribute.PropertyAttribute;

public interface PropertyUpdateListener extends CollectUpdateListener {
    void onPropertyUpdate(PropertyAttribute propertyAttribute, PropertyAttribute propertyAttribute2);
}
