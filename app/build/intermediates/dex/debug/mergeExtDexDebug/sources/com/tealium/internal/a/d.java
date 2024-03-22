package com.tealium.internal.a;

import com.tealium.collect.attribute.AttributeGroup;
import com.tealium.collect.attribute.DateAttribute;
import com.tealium.collect.listeners.DateUpdateListener;

final class d extends a<DateUpdateListener, DateAttribute> {
    public d(AttributeGroup<DateAttribute> attributeGroup, AttributeGroup<DateAttribute> attributeGroup2) {
        super(DateUpdateListener.class, attributeGroup, attributeGroup2);
    }

    public void a(DateUpdateListener dateUpdateListener) {
        if (c() != null) {
            for (DateAttribute onDateUpdate : c()) {
                dateUpdateListener.onDateUpdate(onDateUpdate, (DateAttribute) null);
            }
        }
        if (e() != null) {
            for (DateAttribute dateAttribute : e()) {
                dateUpdateListener.onDateUpdate((DateAttribute) b().get(dateAttribute.getId()), dateAttribute);
            }
        }
        if (d() != null) {
            for (DateAttribute onDateUpdate2 : d()) {
                dateUpdateListener.onDateUpdate((DateAttribute) null, onDateUpdate2);
            }
        }
    }
}
