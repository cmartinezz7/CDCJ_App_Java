package es.santander.branchlocator.common;

import es.santander.branchlocator.BLConstants;

public enum KeyAnalyticsEnum {
    SCREEN_NAME("ScreenName"),
    COMPONENT(BLConstants.COMPONENT),
    COMPONENT_VERSION("ComponentVersion"),
    LANGUAGE("Language"),
    COUNTRY("Country"),
    APP_TYPE("AppType"),
    APP_NAME("AppName"),
    APP_VERSION("AppVersion"),
    PLATFORM("Platform"),
    ERROR_TYPE("ErrorType"),
    ACCESS_COMPONENT("AccessComponent"),
    EVENT_CATEGORY("EventCategory"),
    EVENT_ACTION("EventAction"),
    EVENT_LABEL("EventLabel");
    
    private String key;

    private KeyAnalyticsEnum(String key2) {
        this.key = key2;
    }

    public String getKey() {
        return this.key;
    }
}
