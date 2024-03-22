package com.tealium.collect.listeners;

import com.tealium.collect.attribute.DateAttribute;

public interface DateUpdateListener extends CollectUpdateListener {
    void onDateUpdate(DateAttribute dateAttribute, DateAttribute dateAttribute2);
}
