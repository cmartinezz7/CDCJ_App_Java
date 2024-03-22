package es.santander.branchlocator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import es.santander.branchlocator.common.AnalyticsCallback;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;

public class BLUtils {
    private static AnalyticsCallback analyticsCallbackEvent;
    private static boolean btnBackEnalbed = true;
    private static boolean filtersEnabled = true;
    static Toast mToast;
    private static BLOnLogUser onLogUser = null;
    private static BLFilterEnum[] othersFilterIndexesArr = null;
    private static boolean popularAndOtherFiltersEnabled = true;
    private static BLFilterEnum[] popularFilterIndexesArr = null;
    private static boolean useGooglePlaces = true;

    public static void launchBranchLocator(Context context, boolean arePopularAndOtherFiltersEnabled, boolean areBtnBackEnalbed) {
        popularAndOtherFiltersEnabled = arePopularAndOtherFiltersEnabled;
        btnBackEnalbed = areBtnBackEnalbed;
        Intent intent = new Intent(context, BLMapsLogicActivity.class);
        intent.putExtra("popularFilterIndexes", getStringFromEnumArr(popularFilterIndexesArr));
        intent.putExtra("otherFilterIndexes", getStringFromEnumArr(othersFilterIndexesArr));
        context.startActivity(intent);
    }

    private static String getStringFromEnumArr(BLFilterEnum[] filtersArr) {
        String filters = null;
        if (filtersArr != null) {
            filters = "";
            for (int i = 0; i < filtersArr.length; i++) {
                if (!filters.equals("")) {
                    filters = filters + ",";
                }
                filters = filters + filtersArr[i].value();
            }
        }
        return filters;
    }

    public static boolean getBtnBackIsEnable() {
        return btnBackEnalbed;
    }

    public static void setPopularFiltersForVisibility(BLFilterEnum[] indexes) {
        popularFilterIndexesArr = indexes;
    }

    public static void setOthersFilterForVisibility(BLFilterEnum[] indexes) {
        othersFilterIndexesArr = indexes;
    }

    public static void setPopularFiltersEmpty() {
        popularFilterIndexesArr = new BLFilterEnum[0];
    }

    public static void setOthersFiltersEmpty() {
        othersFilterIndexesArr = new BLFilterEnum[0];
    }

    public static BLOnLogUser init() {
        if (onLogUser == null) {
            onLogUser = new BLOnLogUser() {
                public void onLogin(BLUserType userType) {
                    BLPreferencesManager.isUserLogged = true;
                }

                public void onLogout() {
                    BLPreferencesManager.isUserLogged = false;
                }
            };
        }
        return onLogUser;
    }

    public static List<BLLocation> getGeoCoordsFromPOI(List<BLPoi> pointsOfInterest) {
        List<BLLocation> location = new ArrayList<>();
        for (BLPoi pointOfInterest : pointsOfInterest) {
            if (pointOfInterest.getLocation() != null) {
                location.add(pointOfInterest.getLocation());
            }
        }
        return location;
    }

    public static String generateCoordsForRequest(double lat, double lng) {
        return "{\"coords\":[" + lat + "," + lng + "]}";
    }

    public static void hideSoftKeyboard(Activity activity) {
        if (activity != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.findViewById(16908290).getWindowToken(), 0);
        }
    }

    public static List<BLFilterItem> generateGeneralListFilters(Context context, boolean isPopularList) {
        List<BLFilterItem> filterList = new ArrayList<>();
        if (isPopularList) {
            filterList.addAll(generateDefaultPopularList(context, isPopularList));
        }
        filterList.addAll(generateDefaultOthersList(context, isPopularList));
        return filterList;
    }

    public static List<BLFilterItem> generateDefaultPopularList(Context context, boolean isPopularList) {
        List<BLFilterItem> filterList = new ArrayList<>();
        if (isPopularList) {
            filterList.add(new BLFilterItem((BLFilter) null, BLFilterType.TITLE, context.getResources().getString(R.string.bl_most_popular), -1));
        }
        filterList.addAll(generateDefaultPopularFilter(context));
        return filterList;
    }

    public static List<BLFilterItem> generateDefaultOthersList(Context context, boolean isPopularList) {
        List<BLFilterItem> restOfFilters = new ArrayList<>();
        if (!isPopularList) {
            restOfFilters.add(new BLFilterItem((BLFilter) null, BLFilterType.TITLE, context.getResources().getString(R.string.bl_additional_services), 0));
            restOfFilters.addAll(generateDefaultPopularList(context, false));
        }
        restOfFilters.addAll(generateDefaultServicesFilter(context));
        if (!isPopularList) {
            restOfFilters.add(new BLFilterItem((BLFilter) null, BLFilterType.TITLE, context.getResources().getString(R.string.bl_facilities), 1));
        }
        restOfFilters.addAll(generateDefaultFacilitiesFilter(context));
        if (!isPopularList) {
            restOfFilters.add(new BLFilterItem((BLFilter) null, BLFilterType.TITLE, context.getResources().getString(R.string.bl_accessibility), 2));
        }
        restOfFilters.addAll(generateDefaultAccesibilityFilter(context));
        if (!isPopularList) {
            restOfFilters.add(new BLFilterItem((BLFilter) null, BLFilterType.TITLE, context.getResources().getString(R.string.bl_points_of_interest), 3));
        }
        restOfFilters.addAll(generateDefaultPOIFilter(context));
        return restOfFilters;
    }

    public static List<BLFilterItem> generateDefaultPopularFilter(Context context) {
        List<BLFilterItem> filtersList = new ArrayList<>();
        String str = "";
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_withdraw_money) : str, BLConstants.WITHDRAW_REQUEST, "filterAttributeList", R.drawable.bl_ic_active, false, BLFilterEnum.WITHDRAW_MONEY.value(), true), BLFilterType.NORMAL));
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_deposit_money) : str, BLConstants.DEPOSIT_MONET_REQUEST, "filterAttributeList", R.drawable.bl_ic_active, false, BLFilterEnum.DEPOSIT_MONEY.value(), true), BLFilterType.NORMAL));
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_individuals) : str, BLConstants.INFIVIDUALS_BRANCH_REQUEST, "filterSubtype", R.drawable.bl_ic_blanco, false, BLFilterEnum.INDIVIDUALS_BRANCH.value(), true), BLFilterType.NORMAL));
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_santander_atms_filters) : str, BLConstants.SANTANDER_ATM_REQUEST, "filterSubtype", R.drawable.bl_ic_blanco, false, BLFilterEnum.SANTANDER_ATM.value(), true), BLFilterType.NORMAL));
        if (context != null) {
            str = context.getResources().getString(R.string.bl_workcafe);
        }
        filtersList.add(new BLFilterItem(new BLFilter(str, BLConstants.WORKCAFE_REQUEST, "filterSubtype", R.drawable.bl_ic_negativo, false, BLFilterEnum.WORKCAFE.value(), true), BLFilterType.NORMAL));
        return filtersList;
    }

    public static List<BLFilterItem> generateDefaultServicesFilter(Context context) {
        List<BLFilterItem> filtersList = new ArrayList<>();
        String str = "";
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_withdraw_without_card) : str, BLConstants.WITHDRAW_WITHOUT_CARD_REQUEST, "filterAttributeList", R.drawable.bl_ic_active, false, BLFilterEnum.WITHDRAW_MONEY_WITHOUT_CARD.value(), false), BLFilterType.NORMAL));
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_low_denomination_bills) : str, BLConstants.LOW_DENOMINATION_BILL_REQUEST, "filterAttributeList", R.drawable.bl_ic_active, false, BLFilterEnum.WITH_LOW_DENOMINATION_BILL.value(), false), BLFilterType.NORMAL));
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_contactless) : str, BLConstants.CONTACTLESS_REQUEST, "filterAttributeList", R.drawable.bl_ic_active, false, BLFilterEnum.CONTACTLESS.value(), false), BLFilterType.NORMAL));
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_opens_evenings) : str, BLConstants.OPEN_EVENINGS_REQUEST, "filterAttributeList", R.drawable.bl_ic_active, false, BLFilterEnum.OPEN_EVENINGS.value(), false), BLFilterType.NORMAL));
        if (context != null) {
            str = context.getResources().getString(R.string.bl_opens_saturdays);
        }
        filtersList.add(new BLFilterItem(new BLFilter(str, BLConstants.OPEN_SATURDAY_REQUEST, "filterAttributeList", R.drawable.bl_ic_active, false, BLFilterEnum.OPEN_SATURDAYS.value(), false), BLFilterType.NORMAL));
        return filtersList;
    }

    public static List<BLFilterItem> generateDefaultFacilitiesFilter(Context context) {
        List<BLFilterItem> filtersList = new ArrayList<>();
        String str = "";
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_parking_filters) : str, BLConstants.OWN_PARKING_REQUEST, "filterAttributeList", R.drawable.bl_ic_active, false, BLFilterEnum.OWN_PARKING.value(), false), BLFilterType.NORMAL));
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_coworking_spaces_filters) : str, BLConstants.COWORKING_SPACES_REQUEST, "filterAttributeList", R.drawable.bl_ic_active, false, BLFilterEnum.CO_WORKING_SPACES.value(), false), BLFilterType.NORMAL));
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_wifi_filters) : str, BLConstants.WIFI_REQUEST, "filterAttributeList", R.drawable.bl_ic_active, false, BLFilterEnum.WI_FI.value(), false), BLFilterType.NORMAL));
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_security_box_filters) : str, BLConstants.SAFE_BOX_REQUEST, "filterAttributeList", R.drawable.bl_ic_active, false, BLFilterEnum.SECURITY_BOX.value(), false), BLFilterType.NORMAL));
        if (context != null) {
            str = context.getResources().getString(R.string.bl_drive_thru);
        }
        filtersList.add(new BLFilterItem(new BLFilter(str, BLConstants.DRIVE_THRU_REQUEST, "filterAttributeList", R.drawable.bl_ic_active, false, BLFilterEnum.DRIVE_THRU.value(), false), BLFilterType.NORMAL));
        return filtersList;
    }

    public static List<BLFilterItem> generateDefaultAccesibilityFilter(Context context) {
        List<BLFilterItem> filtersList = new ArrayList<>();
        String str = "";
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_wheelchair_access) : str, BLConstants.WHEELCHAIR_ACCESS_REQUEST, "filterAttributeList", R.drawable.bl_ic_active, false, BLFilterEnum.WHEELCHAIR_ACCESS.value(), false), BLFilterType.NORMAL));
        if (context != null) {
            str = context.getResources().getString(R.string.bl_audio_guidance);
        }
        filtersList.add(new BLFilterItem(new BLFilter(str, BLConstants.AUDIO_GUIDANCE_REQUEST, "filterAttributeList", R.drawable.bl_ic_active, false, BLFilterEnum.AUDIO_GUIDANCE.value(), false), BLFilterType.NORMAL));
        return filtersList;
    }

    public static List<BLFilterItem> generateDefaultPOIFilter(Context context) {
        List<BLFilterItem> filtersList = new ArrayList<>();
        String str = "";
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_santader_select) : str, BLConstants.SANTANDER_SELECT_REQUEST, "filterSubtype", R.drawable.bl_ic_blanco, false, BLFilterEnum.SELECT_BRANCH.value(), false), BLFilterType.NORMAL));
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_private_banking) : str, BLConstants.PRIVATE_BANKING_REQUEST, "filterSubtype", R.drawable.bl_ic_blanco, false, BLFilterEnum.PRIVATE_BANKING_BRANCH.value(), false), BLFilterType.NORMAL));
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_pymes_filters) + "/" + context.getResources().getString(R.string.bl_companies) : str, BLConstants.SME_BRANCH_REQUEST, "filterSubtype", R.drawable.bl_ic_blanco, false, BLFilterEnum.SME_BRANCH.value(), false), BLFilterType.NORMAL));
        filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_partners) : str, BLConstants.PARTNERS_REQUEST, "filterType", R.drawable.bl_ic_partners, false, BLFilterEnum.PARTNERS.value(), false), BLFilterType.NORMAL));
        if (popularAndOtherFiltersEnabled) {
            filtersList.add(new BLFilterItem(new BLFilter(context != null ? context.getResources().getString(R.string.bl_popular) + "/" + context.getResources().getString(R.string.bl_pastor) : str, BLConstants.POPULAR_REQUEST, "filterSubtype", R.drawable.bl_ic_gris, false, BLFilterEnum.POPULAR_BRANCH.value(), false), BLFilterType.NORMAL));
            if (context != null) {
                str = context.getResources().getString(R.string.bl_other_atms);
            }
            filtersList.add(new BLFilterItem(new BLFilter(str, BLConstants.OTHERS_ATM_REQUEST, "filterSubtype", R.drawable.bl_ic_atm_santander, false, BLFilterEnum.OTHER_NON_SANTANDER_ATM.value(), false), BLFilterType.NORMAL));
        }
        return filtersList;
    }

    public static void openGoogleMaps(LatLng latLng, Context context) {
        if (latLng != null) {
            Intent mapIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://maps.google.com/maps?daddr=" + latLng.latitude + "," + latLng.longitude));
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
                getAnalytcsTag(context, "navigate_turn_by_turn_google");
                context.startActivity(mapIntent);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getStringFromFilter(java.lang.String r1, android.content.Context r2) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -2100409959: goto L_0x007c;
                case -1746773511: goto L_0x0072;
                case -743494698: goto L_0x0067;
                case -75219048: goto L_0x005d;
                case 2664213: goto L_0x0053;
                case 168883043: goto L_0x0049;
                case 188798879: goto L_0x003e;
                case 258957447: goto L_0x0034;
                case 483461757: goto L_0x002a;
                case 1092333932: goto L_0x001f;
                case 1402680769: goto L_0x0014;
                case 1522965428: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0087
        L_0x0009:
            java.lang.String r0 = "MEETING_ROOMS"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 5
            goto L_0x0088
        L_0x0014:
            java.lang.String r0 = "AUDIO_GUIDANCE"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 7
            goto L_0x0088
        L_0x001f:
            java.lang.String r0 = "DRIVE_THRU"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 8
            goto L_0x0088
        L_0x002a:
            java.lang.String r0 = "EMBOSADORA"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 1
            goto L_0x0088
        L_0x0034:
            java.lang.String r0 = "COWORKING_SPACES"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 3
            goto L_0x0088
        L_0x003e:
            java.lang.String r0 = "DEPOSIT_MONEY"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 11
            goto L_0x0088
        L_0x0049:
            java.lang.String r0 = "ACCESIBILITY"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 6
            goto L_0x0088
        L_0x0053:
            java.lang.String r0 = "WIFI"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 2
            goto L_0x0088
        L_0x005d:
            java.lang.String r0 = "PARKING"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 4
            goto L_0x0088
        L_0x0067:
            java.lang.String r0 = "LOW_DENOMINATION_BILL"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 10
            goto L_0x0088
        L_0x0072:
            java.lang.String r0 = "SAFE_BOX"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 0
            goto L_0x0088
        L_0x007c:
            java.lang.String r0 = "CONTACTLESS"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 9
            goto L_0x0088
        L_0x0087:
            r0 = -1
        L_0x0088:
            switch(r0) {
                case 0: goto L_0x00db;
                case 1: goto L_0x00d4;
                case 2: goto L_0x00cd;
                case 3: goto L_0x00c6;
                case 4: goto L_0x00bf;
                case 5: goto L_0x00b8;
                case 6: goto L_0x00b1;
                case 7: goto L_0x00aa;
                case 8: goto L_0x00a3;
                case 9: goto L_0x009c;
                case 10: goto L_0x0095;
                case 11: goto L_0x008e;
                default: goto L_0x008b;
            }
        L_0x008b:
            java.lang.String r0 = ""
            return r0
        L_0x008e:
            int r0 = es.santander.branchlocator.R.string.bl_deposit_money
            java.lang.String r0 = r2.getString(r0)
            return r0
        L_0x0095:
            int r0 = es.santander.branchlocator.R.string.bl_low_denomination_bills
            java.lang.String r0 = r2.getString(r0)
            return r0
        L_0x009c:
            int r0 = es.santander.branchlocator.R.string.bl_contactless
            java.lang.String r0 = r2.getString(r0)
            return r0
        L_0x00a3:
            int r0 = es.santander.branchlocator.R.string.bl_drive_thru
            java.lang.String r0 = r2.getString(r0)
            return r0
        L_0x00aa:
            int r0 = es.santander.branchlocator.R.string.bl_audio_guidance
            java.lang.String r0 = r2.getString(r0)
            return r0
        L_0x00b1:
            int r0 = es.santander.branchlocator.R.string.bl_accessibility_handicaped
            java.lang.String r0 = r2.getString(r0)
            return r0
        L_0x00b8:
            int r0 = es.santander.branchlocator.R.string.bl_meeting_rooms
            java.lang.String r0 = r2.getString(r0)
            return r0
        L_0x00bf:
            int r0 = es.santander.branchlocator.R.string.bl_parking
            java.lang.String r0 = r2.getString(r0)
            return r0
        L_0x00c6:
            int r0 = es.santander.branchlocator.R.string.bl_coworking_spaces
            java.lang.String r0 = r2.getString(r0)
            return r0
        L_0x00cd:
            int r0 = es.santander.branchlocator.R.string.bl_wifi
            java.lang.String r0 = r2.getString(r0)
            return r0
        L_0x00d4:
            int r0 = es.santander.branchlocator.R.string.bl_card_issuer
            java.lang.String r0 = r2.getString(r0)
            return r0
        L_0x00db:
            int r0 = es.santander.branchlocator.R.string.bl_security_box
            java.lang.String r0 = r2.getString(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.branchlocator.BLUtils.getStringFromFilter(java.lang.String, android.content.Context):java.lang.String");
    }

    public static int getLocationMode(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode");
        } catch (Exception e) {
            Log.e("ContentValues", e.toString());
            return 4;
        }
    }

    public static void showNoLocationDialog(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.bl_permission));
        if (Build.VERSION.SDK_INT >= 21) {
            builder.setMessage(context.getString(R.string.bl_gps_locate_you));
        } else if (getLocationMode(context) != 3) {
            builder.setMessage(context.getString(R.string.bl_gps_mode));
        } else {
            builder.setMessage(context.getString(R.string.bl_gps_locate_you));
        }
        builder.setPositiveButton(context.getString(R.string.bl_go_to_settings), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface d, int which) {
                context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                d.cancel();
            }
        });
        builder.setNegativeButton(context.getString(R.string.bl_cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }

    public static void setBackground(View view, Context context, int resource) {
        if (Build.VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(ResourcesCompat.getDrawable(context.getResources(), resource, (Resources.Theme) null));
        } else {
            view.setBackground(ResourcesCompat.getDrawable(context.getResources(), resource, (Resources.Theme) null));
        }
    }

    public static String hoursSchedule(BLPoi poi, Context context) {
        String scheduleWeek;
        String scheduleWeek2;
        BLPoiType type = poi.getObjectType();
        if (type == null || type.getCode() == null) {
            return "";
        }
        if ((!type.getCode().toLowerCase().equals("branch") && !type.getCode().toLowerCase().equals("corresponsales")) || poi.getSchedule().getWorkingDay().getMonday().isEmpty()) {
            return "";
        }
        String scheduleWeek3 = context.getResources().getString(R.string.bl_monday) + ": " + poi.getSchedule().getWorkingDay().getMonday().toString() + "\n" + context.getResources().getString(R.string.bl_tuesday) + ": " + poi.getSchedule().getWorkingDay().getTuesday() + "\n" + context.getResources().getString(R.string.bl_wednesday) + ": " + poi.getSchedule().getWorkingDay().getWednesday() + "\n" + context.getResources().getString(R.string.bl_thursday) + ": " + poi.getSchedule().getWorkingDay().getThursday() + "\n" + context.getResources().getString(R.string.bl_friday) + ": " + poi.getSchedule().getWorkingDay().getFriday() + "\n";
        if (!poi.getSchedule().getWorkingDay().getSaturday().isEmpty()) {
            scheduleWeek = scheduleWeek3 + context.getResources().getString(R.string.bl_saturday) + ": " + poi.getSchedule().getWorkingDay().getSaturday() + "\n";
        } else {
            scheduleWeek = scheduleWeek3 + "";
        }
        if (!poi.getSchedule().getWorkingDay().getSunday().isEmpty()) {
            scheduleWeek2 = scheduleWeek + context.getResources().getString(R.string.bl_sunday) + ": " + poi.getSchedule().getWorkingDay().getSunday() + "\n";
        } else {
            scheduleWeek2 = scheduleWeek + "";
        }
        return scheduleWeek2.replace("[", "").replace("]", "");
    }

    public static BLSchedule hoursSchedule3(BLPoi poi, Context context) {
        BLPoiType type = poi.getObjectType();
        BLSchedule schedule = new BLSchedule();
        if (type == null || type.getCode() == null) {
            return schedule;
        }
        if (type.getCode().toLowerCase().equals("branch") || type.getCode().toLowerCase().equals("corresponsales") || type.getCode().toLowerCase().equals("atm") || type.getCode().toLowerCase().equals("non_santander_atm")) {
            if ((poi.getSchedule().getWorkingDay().getMonday() != null) && (!poi.getSchedule().getWorkingDay().getMonday().isEmpty())) {
                schedule.monday = new BLDay(context.getResources().getString(BLDays.MONDAY.getValue()).substring(0, 3), poi.getSchedule().getWorkingDay().getMonday().toString().replace("[", "").replace("]", "").replace(",", ""));
            }
            if ((poi.getSchedule().getWorkingDay().getTuesday() != null) && (!poi.getSchedule().getWorkingDay().getThursday().isEmpty())) {
                schedule.tuesday = new BLDay(context.getResources().getString(BLDays.TUESDAY.getValue()).substring(0, 3), poi.getSchedule().getWorkingDay().getTuesday().toString().replace("[", "").replace("]", "").replace(",", ""));
            }
            if ((poi.getSchedule().getWorkingDay().getWednesday() != null) && (!poi.getSchedule().getWorkingDay().getWednesday().isEmpty())) {
                schedule.wednesday = new BLDay(context.getResources().getString(BLDays.WEDNESDAY.getValue()).substring(0, 3), poi.getSchedule().getWorkingDay().getWednesday().toString().replace("[", "").replace("]", "").replace(",", ""));
            }
            if ((poi.getSchedule().getWorkingDay().getThursday() != null) && (!poi.getSchedule().getWorkingDay().getThursday().isEmpty())) {
                schedule.thursday = new BLDay(context.getResources().getString(BLDays.THURSDAY.getValue()).substring(0, 3), poi.getSchedule().getWorkingDay().getThursday().toString().replace("[", "").replace("]", "").replace(",", ""));
            }
            if ((poi.getSchedule().getWorkingDay().getFriday() != null) && (!poi.getSchedule().getWorkingDay().getFriday().isEmpty())) {
                schedule.friday = new BLDay(context.getResources().getString(BLDays.FRIDAY.getValue()).substring(0, 3), poi.getSchedule().getWorkingDay().getFriday().toString().replace("[", "").replace("]", "").replace(",", ""));
            }
            if ((poi.getSchedule().getWorkingDay().getSaturday() != null) && (!poi.getSchedule().getWorkingDay().getSaturday().isEmpty())) {
                schedule.saturday = new BLDay(context.getResources().getString(BLDays.SATURDAY.getValue()).substring(0, 3), poi.getSchedule().getWorkingDay().getSaturday().toString().replace("[", "").replace("]", "").replace(",", ""));
            }
            if ((poi.getSchedule().getWorkingDay().getSunday() != null) && (true ^ poi.getSchedule().getWorkingDay().getSunday().isEmpty())) {
                schedule.sunday = new BLDay(context.getResources().getString(BLDays.SUNDAY.getValue()).substring(0, 3), poi.getSchedule().getWorkingDay().getSunday().toString().replace("[", "").replace("]", "").replace(",", ""));
            }
        }
        return schedule;
    }

    public static boolean checkIfGpsIsOn(Context context) {
        return ((LocationManager) context.getSystemService("location")).isProviderEnabled("gps");
    }

    public static boolean checkIfNetworkIsOn(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean checkIfWifiIsOn(Context context) {
        return ((WifiManager) context.getApplicationContext().getSystemService("wifi")).isWifiEnabled();
    }

    public static void showAlertDialog(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title).setMessage(message).setNeutralButton("OK", (DialogInterface.OnClickListener) null);
        builder.create().show();
    }

    public static void showCustomToast(Context context, String title) {
        if (mToast == null) {
            mToast = Toast.makeText(context, title, 0);
        }
        if (Build.VERSION.SDK_INT < 30 && !mToast.getView().isShown()) {
            mToast.setView(setupCustomToast(context, title));
        }
        mToast.setDuration(0);
        mToast.show();
    }

    private static View setupCustomToast(Context context, String title) {
        View toastView = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.custom_toast, (ViewGroup) null);
        ((BLTextView) toastView.findViewById(R.id.toast_title)).setText(title);
        return toastView;
    }

    public static BLLayoutManager getLayoutManager(Context context, boolean scroll) {
        BLLayoutManager linearLayoutManager = new BLLayoutManager(context);
        linearLayoutManager.setScrollEnabled(scroll);
        return linearLayoutManager;
    }

    public static void getAnalytcsTag(Context context, String eventName) {
    }

    public static BLFeesResponse mockFees() {
        return (BLFeesResponse) new Gson().fromJson(BLMockConstants.fees_json_example, BLFeesResponse.class);
    }

    public static String getCountryISO(Context context) {
        return context.getResources().getConfiguration().locale.getCountry();
    }

    public static String getCountryISOLowerCase(Context context) {
        return getCountryISO(context).toLowerCase();
    }

    public static String getBasicInfoFees(BLPoi atm, boolean isLogged, Context context) {
        if (atm.getFees() == null) {
            return "";
        }
        String countryISO = getCountryISO(context);
        String feeString = "";
        BLFeesResponse fees = atm.getFees();
        if (fees.getFees().size() > 0) {
            for (BLFee fee : fees.getFees()) {
                if (fee.getId().equals(countryISO)) {
                    if (fee.getFee().equals("0")) {
                        if (isLogged) {
                            feeString = context.getString(R.string.bl_fees_no_fee);
                        } else {
                            feeString = String.format(context.getString(R.string.bl_fees_basic_no_clients), new Object[]{context.getString(R.string.bl_fees_no_fee)});
                        }
                    } else if (isLogged) {
                        feeString = String.format(context.getString(R.string.bl_fees_basic_clients), new Object[]{fee.getFee() + "€"});
                    } else {
                        feeString = String.format(context.getString(R.string.bl_fees_basic_no_clients), new Object[]{fee.getFee() + "€"});
                    }
                }
            }
        }
        return feeString;
    }

    public static String getDetailedInformationFees(BLPoi atm, Context context) {
        Context context2 = context;
        boolean isLocalCustomer = true;
        String countryISO = getCountryISO(context);
        String nonCustomerFee = "";
        String selectFee = "";
        String santanderFee = "";
        BLFeesResponse fees = atm.getFees();
        if (!fees.getCountryId().equals(countryISO)) {
            isLocalCustomer = false;
        }
        if (fees.getFees().size() > 0) {
            for (BLFee fee : fees.getFees()) {
                String id = fee.getId();
                char c = 65535;
                int hashCode = id.hashCode();
                if (hashCode != -1152018012) {
                    if (hashCode != 641615579) {
                        if (hashCode == 1557320641 && id.equals("SELECT_CUSTOMER")) {
                            c = 2;
                        }
                    } else if (id.equals("FOREIGN_NON_CUSTOMER")) {
                        c = 1;
                    }
                } else if (id.equals("LOCAL_NON_CUSTOMER")) {
                    c = 0;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c == 2) {
                            selectFee = String.format(context2.getString(R.string.bl_fees_select), new Object[]{getFeeString(fee.getFee(), context2)});
                        }
                    } else if (!isLocalCustomer) {
                        nonCustomerFee = String.format(context2.getString(R.string.bl_fees_no_client), new Object[]{getFeeString(fee.getFee(), context2)});
                    }
                } else if (isLocalCustomer) {
                    nonCustomerFee = String.format(context2.getString(R.string.bl_fees_no_client), new Object[]{getFeeString(fee.getFee(), context2)});
                }
                if (fee.getId().equals(countryISO)) {
                    santanderFee = String.format(context2.getString(R.string.bl_fees_santander), new Object[]{getFeeString(fee.getFee(), context2)});
                }
            }
        }
        return santanderFee + "\n" + selectFee + "\n" + nonCustomerFee;
    }

    private static String getFeeString(String fee, Context context) {
        return fee.replace(",", ".").equals("0") ? context.getString(R.string.bl_fees_no_fee) : fee + "€";
    }

    public static BLOnLogUser getOnLogUser() {
        return onLogUser;
    }

    public static String getDistanceWithUser(Context context, LatLng userLocation, LatLng poiLocation) {
        String distancePattern;
        int stringId;
        if (userLocation == null || poiLocation == null) {
            return "";
        }
        float distance = BLMapUtils.distanceBetweenPoints(userLocation, poiLocation);
        double distanceFinal = (double) distance;
        if (Locale.getDefault().getLanguage().equals("en")) {
            distanceFinal = ((double) distance) * 0.621d;
        }
        if (((double) distance) >= 1.0d) {
            stringId = R.string.bl_kilometer;
            distancePattern = "%#.2f";
        } else {
            distancePattern = "%.0f";
            distanceFinal *= 1000.0d;
            stringId = R.string.bl_meter;
        }
        return context.getString(stringId, new Object[]{String.format(distancePattern, new Object[]{Double.valueOf(distanceFinal)})});
    }

    public static String lowerCaseWithFirstLetter(String textToLowerCase) {
        return textToLowerCase.substring(0, 1).toUpperCase() + textToLowerCase.toLowerCase().substring(1);
    }

    public static String formatOneDecimal(double value) {
        return String.valueOf(((double) Math.round(value * 10.0d)) / 10.0d);
    }

    public static String capitalizeString(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        String resultString = string.toLowerCase();
        return resultString.substring(0, 1).toUpperCase() + resultString.substring(1);
    }

    public static String capitalizeAllString(String string) {
        StringBuilder sb = null;
        if (string != null && !string.isEmpty()) {
            sb = new StringBuilder(string.toLowerCase());
            for (int i = 0; i < sb.length(); i++) {
                if (i == 0 || sb.charAt(i - 1) == ' ') {
                    sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
                }
            }
        }
        return sb != null ? sb.toString() : "";
    }

    public static String capitalizeStringAfterLineBreak(String sentence) {
        StringBuilder result = new StringBuilder(sentence.length());
        boolean capitalize = true;
        if (sentence != null) {
            if (!sentence.equals("")) {
                sentence = sentence.toLowerCase();
            }
            for (int i = 0; i < sentence.length(); i++) {
                char currentCharacter = sentence.charAt(i);
                if (currentCharacter == 10) {
                    capitalize = true;
                } else if (capitalize && Character.isLetter(currentCharacter)) {
                    currentCharacter = Character.toUpperCase(currentCharacter);
                    capitalize = false;
                }
                result.append(currentCharacter);
            }
        }
        return result.toString();
    }

    public static void useGooglePlaces() {
        useGooglePlaces = true;
    }

    public static void notUseGooglePlaces() {
        useGooglePlaces = false;
    }

    public static boolean isUseGooglePlaces() {
        return useGooglePlaces;
    }

    public static boolean isFiltersEnabled() {
        return filtersEnabled;
    }

    public static void setFiltersEnabled(boolean filtersEnabled2) {
        filtersEnabled = filtersEnabled2;
    }

    public static boolean isMexico(Context context) {
        String locale;
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (locale = context.getResources().getConfiguration().locale.getCountry()) == null || !locale.equals(BLConstants.MX_COUNTRY_CODE)) {
            return false;
        }
        return true;
    }

    public static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public static String replaceLast(String string, String substring, String replacement) {
        int index = string.lastIndexOf(substring);
        if (index == -1 || index != string.length() - 1) {
            return string;
        }
        return string.substring(0, index) + replacement + string.substring(substring.length() + index);
    }

    public static String joinListToString(List<String> list, String character) {
        String result = "";
        if (list != null) {
            for (String s : list) {
                result = result + s + character;
            }
        }
        return result;
    }

    public static String removeDuplicates(String inputString) {
        if (inputString == null || inputString.equals("")) {
            return inputString;
        }
        LinkedHashSet<String> lhSetWords = new LinkedHashSet<>(Arrays.asList(inputString.split("\\n+")));
        StringBuilder sbTemp = new StringBuilder();
        int index = 0;
        Iterator it = lhSetWords.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            if (index > 0) {
                sbTemp.append("\n");
            }
            sbTemp.append(s);
            index++;
        }
        return sbTemp.toString();
    }

    public static String stripAccents(String s) {
        return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }

    public static void setAnalyticsCallbackEvent(AnalyticsCallback analyticsCallbackParam) {
        analyticsCallbackEvent = analyticsCallbackParam;
    }

    public static AnalyticsCallback getAnalyticsCallbackEvent() {
        return analyticsCallbackEvent;
    }
}
