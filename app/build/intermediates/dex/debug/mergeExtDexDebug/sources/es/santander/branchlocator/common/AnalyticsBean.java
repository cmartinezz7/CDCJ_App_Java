package es.santander.branchlocator.common;

import java.util.HashMap;
import java.util.Map;

public class AnalyticsBean {
    private String component;
    private String componentVersion;
    private String event;
    private HashMap<String, Object> params;
    private String screen;

    AnalyticsBean(String screen2, String event2, String component2, String componentVersion2) {
        this.screen = screen2;
        this.event = event2;
        this.component = component2;
        this.componentVersion = componentVersion2;
    }

    public boolean isEvent() {
        String str = this.event;
        return str != null && !str.isEmpty();
    }

    public String getScreen() {
        return this.screen;
    }

    public void setScreen(String screen2) {
        this.screen = screen2;
    }

    public String getEvent() {
        return this.event;
    }

    public void setEvent(String event2) {
        this.event = event2;
    }

    public String getComponent() {
        return this.component;
    }

    public void setComponent(String component2) {
        this.component = component2;
    }

    public String getComponentVersion() {
        return this.componentVersion;
    }

    public void setComponentVersion(String componentVersion2) {
        this.componentVersion = componentVersion2;
    }

    public HashMap<String, Object> getParams() {
        return this.params;
    }

    public void setParams(HashMap<String, Object> params2) {
        this.params = params2;
    }

    /* access modifiers changed from: package-private */
    public void generateDataLayer(Map<String, String> data) {
        HashMap<String, Object> hashMap = new HashMap<>();
        this.params = hashMap;
        hashMap.putAll(data);
        String str = this.screen;
        if (str != null && !str.isEmpty()) {
            this.params.put(KeyAnalyticsEnum.SCREEN_NAME.getKey(), this.screen);
        }
        this.params.put(KeyAnalyticsEnum.COMPONENT.getKey(), this.component);
        this.params.put(KeyAnalyticsEnum.COMPONENT_VERSION.getKey(), this.componentVersion);
    }
}
