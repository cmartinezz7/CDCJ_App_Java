package es.santander.branchlocator.common;

import es.santander.branchlocator.BLConstants;
import es.santander.branchlocator.BLUtils;
import es.santander.branchlocator.BuildConfig;
import java.util.Map;

public class AnalyticsComponentHelper {
    public static void trackView(String viewName, Map<String, String> data) {
        AnalyticsBean analyticsBean = new AnalyticsBean(viewName, "", BLConstants.BRANCH_LOCATOR, BuildConfig.VERSION_NAME);
        analyticsBean.generateDataLayer(data);
        if (BLUtils.getAnalyticsCallbackEvent() != null) {
            BLUtils.getAnalyticsCallbackEvent().trackAnalytics(analyticsBean);
        }
    }

    public static void trackEvent(String eventName, Map<String, String> data) {
        AnalyticsBean analyticsBean = new AnalyticsBean("", eventName, BLConstants.BRANCH_LOCATOR, BuildConfig.VERSION_NAME);
        analyticsBean.generateDataLayer(data);
        if (BLUtils.getAnalyticsCallbackEvent() != null) {
            BLUtils.getAnalyticsCallbackEvent().trackAnalytics(analyticsBean);
        }
    }
}
