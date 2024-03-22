package com.santander.globile.mobisec.securekeyboard.scrolling;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class AutoScrollSynchronicer {
    private static AutoScrollSynchronicer INSTANCE;
    private Map<String, AutoScrollManager> autoScrollManagersMap;
    private Map<String, Integer> managerSubscriptionsMap;

    public static AutoScrollSynchronicer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AutoScrollSynchronicer();
        }
        return INSTANCE;
    }

    private AutoScrollSynchronicer() {
    }

    public synchronized AutoScrollManager getAutoScrollManagerFor(Context context, String owner, int rootLayoutResourceId, int indexInViewParent) {
        AutoScrollManager manager;
        String key = getKeyForRootLayout(owner, rootLayoutResourceId, indexInViewParent);
        initAutoScrollManagerMap();
        manager = this.autoScrollManagersMap.get(key);
        if (manager == null) {
            manager = new AutoScrollManager(context, rootLayoutResourceId);
            this.autoScrollManagersMap.put(key, manager);
        } else {
            manager.resetIfNecessary();
        }
        addSubscriber(key);
        return manager;
    }

    private void addSubscriber(String key) {
        initSubscribersMap();
        Integer subscribersCount = this.managerSubscriptionsMap.get(key);
        if (subscribersCount == null) {
            this.managerSubscriptionsMap.put(key, 1);
        } else {
            this.managerSubscriptionsMap.put(key, Integer.valueOf(subscribersCount.intValue() + 1));
        }
    }

    public void releaseAutoScrollManagerFor(String owner, int rootLayoutResourceId, int indexInViewParent) {
        String key = getKeyForRootLayout(owner, rootLayoutResourceId, indexInViewParent);
        Integer subscribersCount = this.managerSubscriptionsMap.get(key);
        if (subscribersCount != null && subscribersCount.intValue() > 0) {
            if (subscribersCount.intValue() == 1) {
                AutoScrollManager asm = this.autoScrollManagersMap.remove(key);
                if (asm != null) {
                    asm.onDestroy();
                }
                this.managerSubscriptionsMap.remove(key);
            } else {
                this.managerSubscriptionsMap.put(key, Integer.valueOf(subscribersCount.intValue() - 1));
            }
        }
        releaseAutoScrollManagerMap();
        releaseSubscribersMap();
    }

    private String getKeyForRootLayout(String owner, int rootLayoutResourceId, int rootLayoutIndexInViewPager) {
        return owner + "@" + rootLayoutResourceId + "@" + rootLayoutIndexInViewPager;
    }

    private void initAutoScrollManagerMap() {
        if (this.autoScrollManagersMap == null) {
            this.autoScrollManagersMap = new HashMap();
        }
    }

    private void initSubscribersMap() {
        if (this.managerSubscriptionsMap == null) {
            this.managerSubscriptionsMap = new HashMap();
        }
    }

    private void releaseAutoScrollManagerMap() {
        Map<String, AutoScrollManager> map = this.autoScrollManagersMap;
        if (map != null && map.isEmpty()) {
            this.autoScrollManagersMap = null;
        }
    }

    private void releaseSubscribersMap() {
        Map<String, Integer> map = this.managerSubscriptionsMap;
        if (map != null && map.isEmpty()) {
            this.managerSubscriptionsMap = null;
        }
    }
}
