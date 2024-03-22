package com.santander.globile.mobisec.securekeyboard.window;

import android.view.Window;
import java.util.HashMap;
import java.util.Map;

public class KeyboardWindowSynchronizer {
    private static KeyboardWindowSynchronizer INSTANCE;
    private Map<KeyboardWindowManager, Integer> subscribersMap;
    private Map<Window, KeyboardWindowManager> windowsMap;

    public static KeyboardWindowSynchronizer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new KeyboardWindowSynchronizer();
        }
        return INSTANCE;
    }

    private KeyboardWindowSynchronizer() {
    }

    public KeyboardWindowManager getWindowManagerFor(Window window) {
        initWindowsMap();
        KeyboardWindowManager manager = this.windowsMap.get(window);
        if (manager == null) {
            manager = new KeyboardWindowManager(window);
            this.windowsMap.put(window, manager);
        }
        addSubscriber(manager);
        return manager;
    }

    private void addSubscriber(KeyboardWindowManager key) {
        initSubscribersMap();
        Integer subscribersCount = this.subscribersMap.get(key);
        if (subscribersCount == null) {
            this.subscribersMap.put(key, 1);
        } else {
            this.subscribersMap.put(key, Integer.valueOf(subscribersCount.intValue() + 1));
        }
    }

    public void releaseWindowManagerFor(KeyboardWindowManager windowManager) {
        Integer subscribersCount = this.subscribersMap.get(windowManager);
        if (subscribersCount != null && subscribersCount.intValue() > 0) {
            if (subscribersCount.intValue() == 1) {
                KeyboardWindowManager kwm = this.windowsMap.remove(windowManager.getManagedWindow());
                if (kwm != null) {
                    kwm.onDestroy();
                }
                this.subscribersMap.remove(windowManager);
            } else {
                this.subscribersMap.put(windowManager, Integer.valueOf(subscribersCount.intValue() - 1));
            }
        }
        releaseWindowsMap();
        releaseSubscribersMap();
    }

    private void initWindowsMap() {
        if (this.windowsMap == null) {
            this.windowsMap = new HashMap();
        }
    }

    private void initSubscribersMap() {
        if (this.subscribersMap == null) {
            this.subscribersMap = new HashMap();
        }
    }

    private void releaseWindowsMap() {
        Map<Window, KeyboardWindowManager> map = this.windowsMap;
        if (map != null && map.isEmpty()) {
            this.windowsMap = null;
        }
    }

    private void releaseSubscribersMap() {
        Map<KeyboardWindowManager, Integer> map = this.subscribersMap;
        if (map != null && map.isEmpty()) {
            this.subscribersMap = null;
        }
    }
}
