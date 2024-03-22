package es.santander.branchlocator;

import android.content.Context;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;
import com.google.maps.android.clustering.ClusterItem;
import es.santander.branchlocator.data.BLAttrib;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BLPoi implements ClusterItem {
    private String action;
    @SerializedName("appointment")
    private Appointment appointment;
    private List<BLPoi> atms = new ArrayList();
    @SerializedName("attrib")
    private List<BLAttrib> attribList;
    @SerializedName("code")
    private String code;
    @SerializedName("comercialProducts")
    private List<Map<String, String>> comercialProducts;
    @SerializedName("contactData")
    private ContactData contactData;
    @SerializedName("dialogAttribute")
    private HashMap<String, String> dialogAttribute;
    @SerializedName("distanceInKm")
    private double distanceInKm;
    @SerializedName("distanceInMiles")
    private double distanceInMiles;
    @SerializedName("entityCode")
    private String entityCode;
    private String extraAccessibility = "";
    private List<Map<String, String>> extraCommercialProducts;
    private String extraFinancialServices = "";
    private String extraNonFinancialServices = "";
    private BLFeesResponse fees;
    @SerializedName("id")
    private String id;
    private boolean isInBranch = false;
    @SerializedName("location")
    private BLLocation location;
    private LatLng mPosition;
    private String mSnippet;
    private String mTitle;
    @SerializedName("name")
    private String name;
    @SerializedName("objectType")
    private BLPoiType objectType;
    @SerializedName("poiStatus")
    private String poiStatus;
    @SerializedName("richTexts")
    private List<BLPoiType> richTexts;
    @SerializedName("schedule")
    private Schedule schedule;
    @SerializedName("scheduleCash")
    private List<String> scheduleCash;
    private List<String> scheduleCashList = new ArrayList();
    @SerializedName("specialType")
    private BLPoiType specialType;
    @SerializedName("subType")
    private BLPoiType subType;
    private boolean toBeSelected = false;

    public BLLocation getLocation() {
        return this.location;
    }

    public void addExtraCommercialProducts(Map<String, String> value) {
        if (this.extraCommercialProducts == null) {
            this.extraCommercialProducts = new ArrayList();
        }
        this.extraCommercialProducts.add(value);
    }

    public void addExtraFinancialServices(String value) {
        String str = this.extraFinancialServices;
        if (str == null) {
            this.extraFinancialServices = "";
        } else if (!str.endsWith("\n")) {
            this.extraFinancialServices += "\n";
        }
        this.extraFinancialServices += value;
    }

    public void addExtraNonFinancialServices(String value) {
        String str = this.extraNonFinancialServices;
        if (str == null) {
            this.extraNonFinancialServices = "";
        } else if (!str.endsWith("\n")) {
            this.extraNonFinancialServices += "\n";
        }
        this.extraNonFinancialServices += value;
    }

    public void addExtraAccesibility(String value) {
        String str = this.extraAccessibility;
        if (str == null) {
            this.extraAccessibility = "";
        } else if (!str.endsWith("\n")) {
            this.extraAccessibility += "\n";
        }
        this.extraAccessibility += value;
    }

    public void cleanExtrasMix() {
        this.extraFinancialServices = "";
        this.extraNonFinancialServices = "";
        this.extraAccessibility = "";
        this.extraCommercialProducts = null;
    }

    public void setClusterInfo() {
        BLLocation bLLocation = this.location;
        if (!(bLLocation == null || bLLocation.getGeoCoordinate() == null)) {
            this.mPosition = new LatLng(this.location.getGeoCoordinate().getLatitude(), this.location.getGeoCoordinate().getLongitude());
        }
        if (!TextUtils.isEmpty(this.name)) {
            this.mTitle = this.name;
        }
        if (!TextUtils.isEmpty(this.name)) {
            this.mSnippet = this.name;
        }
    }

    public LatLng getPosition() {
        return this.mPosition;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getSnippet() {
        return this.mSnippet;
    }

    public String getId() {
        return this.id;
    }

    public BLPoiType getObjectType() {
        return this.objectType;
    }

    public double getDistanceInKm() {
        return this.distanceInKm;
    }

    public double getDistanceInMiles() {
        return this.distanceInMiles;
    }

    public Schedule getSchedule() {
        return this.schedule;
    }

    public List<String> getScheduleCash() {
        return this.scheduleCash;
    }

    public String getPoiStatus() {
        return this.poiStatus;
    }

    public void setPoiStatus(String poiStatus2) {
        this.poiStatus = poiStatus2;
    }

    public void setScheduleCash(List<String> scheduleCashList2) {
        this.scheduleCash = scheduleCashList2;
    }

    public boolean isToBeSelected() {
        return this.toBeSelected;
    }

    public void setToBeSelected(boolean toBeSelected2) {
        this.toBeSelected = toBeSelected2;
    }

    public List<BLPoi> getAtms() {
        return this.atms;
    }

    public LatLng getLatLng() {
        BLLocation bLLocation = this.location;
        if (bLLocation == null || bLLocation.getGeoCoordinate() == null) {
            return null;
        }
        return new LatLng(this.location.getGeoCoordinate().getLatitude(), this.location.getGeoCoordinate().getLongitude());
    }

    public boolean isInBranch() {
        return this.isInBranch;
    }

    public void setInBranch(boolean inBranch) {
        this.isInBranch = inBranch;
    }

    public ContactData contactData() {
        return this.contactData;
    }

    public Appointment appointment() {
        return this.appointment;
    }

    public List<BLPoiType> getRichTexts() {
        if (this.richTexts != null) {
            return new ArrayList(this.richTexts);
        }
        return null;
    }

    public void setRichTexts(List<BLPoiType> richTexts2) {
        this.richTexts = new ArrayList(richTexts2);
    }

    public HashMap<String, String> getDialogAttribute() {
        return new HashMap<>(this.dialogAttribute);
    }

    public void setDialogAttribute(HashMap<String, String> dialogAttribute2) {
        this.dialogAttribute = new HashMap<>(dialogAttribute2);
    }

    public BLPoiType getSubType() {
        return this.subType;
    }

    public void setSubType(BLPoiType subType2) {
        this.subType = subType2;
    }

    public BLPoiType getSpecialType() {
        return this.specialType;
    }

    public void setSpecialType(BLPoiType specialType2) {
        this.specialType = specialType2;
    }

    public List<Map<String, String>> getComercialProducts() {
        List<Map<String, String>> resultList = this.comercialProducts != null ? new ArrayList<>(this.comercialProducts) : null;
        List<Map<String, String>> list = this.extraCommercialProducts;
        if (list != null && list.size() > 0) {
            if (resultList == null) {
                resultList = new ArrayList<>();
            }
            resultList.addAll(this.extraCommercialProducts);
        }
        return resultList;
    }

    public void setComercialProducts(List<Map<String, String>> comercialProducts2) {
        this.comercialProducts = new ArrayList(comercialProducts2);
    }

    public BLFeesResponse getFees() {
        return this.fees;
    }

    public void setFees(BLFeesResponse fees2) {
        this.fees = fees2;
    }

    private String getServices(List<String> services, Context context) {
        String servicesString = "";
        HashMap<String, String> hashMap = this.dialogAttribute;
        if (hashMap == null || hashMap.size() == 0) {
            return servicesString;
        }
        for (String service : services) {
            if (this.dialogAttribute.containsKey(service)) {
                servicesString = servicesString + BLUtils.getStringFromFilter(service, context) + "\n";
            }
        }
        return BLUtils.replaceLast(servicesString, "\n", "");
    }

    public ArrayList<String> getServicesList(List<String> services, Context context) {
        ArrayList<String> servicesList = new ArrayList<>();
        HashMap<String, String> hashMap = this.dialogAttribute;
        if (hashMap == null || hashMap.size() == 0) {
            return servicesList;
        }
        for (String service : services) {
            if (this.dialogAttribute.containsKey(service)) {
                servicesList.add(BLUtils.getStringFromFilter(service, context) + "\n");
            }
        }
        return servicesList;
    }

    private String getFinancialServicesFromComercialProducts() {
        String value;
        String financialServices = "";
        List<Map<String, String>> list = this.comercialProducts;
        if (list == null || list.size() == 0) {
            return financialServices;
        }
        for (Map<String, String> comercialMap : this.comercialProducts) {
            for (String key : comercialMap.keySet()) {
                if (key != null && key.equals("default") && (value = comercialMap.get(key)) != null && !value.equals("")) {
                    financialServices = financialServices + value + "\n";
                }
            }
        }
        return financialServices;
    }

    private String getFinancialInfoFromAttibut(Context context) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> requestSelectedList = getRequestSelectedList();
        if (requestSelectedList != null && requestSelectedList.size() > 0) {
            Iterator<String> it = requestSelectedList.iterator();
            while (it.hasNext()) {
                String request = it.next();
                if (request != null && request.equals(BLConstants.WITHDRAW_REQUEST)) {
                    list.add(context.getString(R.string.bl_withdraw_money));
                } else if (request != null && request.equals(BLConstants.WITHDRAW_WITHOUT_CARD_REQUEST)) {
                    list.add(context.getString(R.string.bl_withdraw_without_card));
                } else if (request != null && request.equals(BLConstants.DEPOSIT_MONET_REQUEST)) {
                    list.add(context.getString(R.string.bl_deposit_money));
                } else if (request != null && request.equals(BLConstants.LOW_DENOMINATION_BILL_REQUEST)) {
                    list.add(context.getString(R.string.bl_low_denomination_bills));
                } else if (request != null && request.equals(BLConstants.CONTACTLESS_REQUEST)) {
                    list.add(context.getString(R.string.bl_contactless));
                } else if (request != null && request.equals(BLConstants.OTHERS_ATM_REQUEST)) {
                    list.add(context.getString(R.string.bl_other_atms));
                }
            }
        }
        if (list.size() > 0) {
            return BLUtils.joinListToString(list, "\n");
        }
        return "";
    }

    private String getNonFinancialInfoFromAttibut(Context context) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> requestSelectedList = getRequestSelectedList();
        if (requestSelectedList != null && requestSelectedList.size() > 0) {
            Iterator<String> it = requestSelectedList.iterator();
            while (it.hasNext()) {
                String request = it.next();
                if (request != null && request.equals(BLConstants.OPEN_EVENINGS_REQUEST)) {
                    list.add(context.getString(R.string.bl_opens_evenings));
                } else if (request != null && request.equals(BLConstants.OPEN_SATURDAY_REQUEST)) {
                    list.add(context.getString(R.string.bl_opens_saturdays));
                } else if (request != null && request.equals(BLConstants.WIFI_REQUEST)) {
                    list.add(context.getString(R.string.bl_wifi));
                }
            }
        }
        if (list.size() > 0) {
            return BLUtils.joinListToString(list, "\n");
        }
        return "";
    }

    private String getAccesibilityFromAtrib(Context context) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> requestSelectedList = getRequestSelectedList();
        if (requestSelectedList != null && requestSelectedList.size() > 0) {
            Iterator<String> it = requestSelectedList.iterator();
            while (it.hasNext()) {
                String request = it.next();
                if (request != null && request.equals(BLConstants.WHEELCHAIR_ACCESS_REQUEST)) {
                    list.add(context.getString(R.string.bl_wheelchair_access));
                } else if (request != null && request.equals(BLConstants.AUDIO_GUIDANCE_REQUEST)) {
                    list.add(context.getString(R.string.bl_audio_guidance));
                }
            }
        }
        if (list.size() > 0) {
            return "\n" + BLUtils.joinListToString(list, "\n");
        }
        return "";
    }

    private ArrayList<String> getRequestSelectedList() {
        ArrayList<String> listSelected = new ArrayList<>();
        List<BLAttrib> list = this.attribList;
        if (list != null && list.size() > 0) {
            for (BLAttrib attrib : this.attribList) {
                if (attrib.getMulti() != null && (attrib.getMulti().getDefault().equalsIgnoreCase("SI") || attrib.getMulti().getDefault().equalsIgnoreCase("YES"))) {
                    listSelected.add(attrib.getCode());
                }
            }
        }
        return listSelected;
    }

    public String getPhone() {
        ContactData contactData2 = this.contactData;
        if (contactData2 == null || TextUtils.isEmpty(contactData2.getPhoneNumber())) {
            return "";
        }
        return String.valueOf(this.contactData.phoneNumber);
    }

    public String getFinancialServices(Context context, boolean isAtm) {
        String financialInfo = getServices(BLConstants.FINANCIAL_SERVICES, context);
        if (!financialInfo.equals("") && !financialInfo.endsWith("\n")) {
            financialInfo = financialInfo + "\n";
        }
        if (!isAtm) {
            financialInfo = financialInfo + getFinancialServicesFromComercialProducts();
        }
        if (!financialInfo.equals("") && !financialInfo.endsWith("\n")) {
            financialInfo = financialInfo + "\n";
        }
        String financialInfo2 = financialInfo + getFinancialInfoFromAttibut(context);
        String str = this.extraFinancialServices;
        if (str != null && !str.equals("")) {
            if (financialInfo2 == null) {
                financialInfo2 = "";
            } else if (!financialInfo2.endsWith("\n")) {
                financialInfo2 = financialInfo2 + "\n";
            }
            financialInfo2 = financialInfo2 + this.extraFinancialServices;
        }
        return BLUtils.capitalizeStringAfterLineBreak(BLUtils.removeDuplicates(BLUtils.replaceLast(financialInfo2, "\n", "").replaceAll("\n\n+", "\n")));
    }

    public String getNonFinancialServices(Context context) {
        String noFinancialInfo = getServices(BLConstants.NON_FINANCIAL_SERVICES, context);
        if (!noFinancialInfo.equals("") && !noFinancialInfo.endsWith("\n")) {
            noFinancialInfo = noFinancialInfo + "\n";
        }
        String noFinancialInfo2 = noFinancialInfo + getNonFinancialInfoFromAttibut(context);
        String str = this.extraNonFinancialServices;
        if (str != null && !str.equals("")) {
            if (noFinancialInfo2 == null) {
                noFinancialInfo2 = "";
            } else if (!noFinancialInfo2.endsWith("\n")) {
                noFinancialInfo2 = noFinancialInfo2 + "\n";
            }
            noFinancialInfo2 = noFinancialInfo2 + this.extraNonFinancialServices;
        }
        return BLUtils.capitalizeStringAfterLineBreak(BLUtils.removeDuplicates(BLUtils.replaceLast(noFinancialInfo2, "\n", "").replaceAll("\n\n+", "\n")));
    }

    public String getBranchAccessibility(Context context) {
        String accessibilityInfo = getServices(BLConstants.BRANCH_ACCESSIBILITY, context);
        String str = this.extraAccessibility;
        if (str != null && !str.equals("")) {
            if (accessibilityInfo == null) {
                accessibilityInfo = "";
            } else if (!accessibilityInfo.endsWith("\n")) {
                accessibilityInfo = accessibilityInfo + "\n";
            }
            accessibilityInfo = accessibilityInfo + this.extraAccessibility;
        }
        return BLUtils.capitalizeStringAfterLineBreak(BLUtils.removeDuplicates(BLUtils.replaceLast(accessibilityInfo + getAccesibilityFromAtrib(context), "\n", "")));
    }

    public String getLocationServices(Context context) {
        return getServices(BLConstants.LOCATION_SERVICES, context);
    }

    public String getAditionalServices(Context context) {
        String result = getServices(BLConstants.ADITIONAL_SERVICES, context);
        if (result != null) {
            result = result.replaceAll("\n\n+", "\n");
        }
        if (result.startsWith("\n")) {
            return result.replaceFirst("\n", "");
        }
        return result;
    }

    public SpannableStringBuilder getNewsAndNotices(Context context) {
        String newsAndNotices = "";
        List<BLPoiType> richTexts2 = getRichTexts();
        ArrayList<String> startEndCode = new ArrayList<>();
        if (richTexts2 != null && richTexts2.size() > 0) {
            for (BLPoiType richText : richTexts2) {
                if (TextUtils.isEmpty(newsAndNotices)) {
                    StringBuilder text = new StringBuilder();
                    String[] textParts = BLUtils.lowerCaseWithFirstLetter(richText.getTranslationString(context)).split("#");
                    for (int i = 0; i < textParts.length; i++) {
                        text.append(BLUtils.capitalizeString(textParts[i]));
                        if (i != textParts.length - 1) {
                            text.append(" / ");
                        }
                    }
                    String textString = Html.fromHtml(text.toString()).toString();
                    if (richText.getCode().equals("20") || richText.getCode().equals("3")) {
                        newsAndNotices = textString.toUpperCase();
                    } else {
                        startEndCode.add(0 + "," + textString.length() + "," + richText.getCode());
                        newsAndNotices = textString;
                    }
                } else {
                    String text2 = Html.fromHtml(BLUtils.lowerCaseWithFirstLetter(richText.getTranslationString(context))).toString();
                    if (richText.getCode().equals("20") || richText.getCode().equals("3")) {
                        newsAndNotices = newsAndNotices + "\n" + text2.toUpperCase();
                    } else {
                        startEndCode.add(newsAndNotices.length() + "," + (newsAndNotices + "\n" + text2).length() + "," + richText.getCode());
                        newsAndNotices = newsAndNotices + "\n" + text2;
                    }
                }
            }
        }
        SpannableStringBuilder sb = new SpannableStringBuilder(newsAndNotices);
        int i2 = 0;
        while (i2 < startEndCode.size()) {
            try {
                String[] start_end_code = startEndCode.get(i2).split(",");
                int start = Integer.valueOf(start_end_code[0]).intValue();
                int end = Integer.valueOf(start_end_code[1]).intValue();
                int code2 = Integer.valueOf(start_end_code[2]).intValue();
                if (code2 == 1) {
                    sb.setSpan(new ForegroundColorSpan(-65536), start, end, 18);
                } else if (code2 == 2) {
                    sb.setSpan(new StyleSpan(1), start, end, 18);
                }
                i2++;
            } catch (Exception e) {
            }
        }
        return sb;
    }

    public String getBasicServices(Context context) {
        String basicServices = "";
        List<Map<String, String>> comercialProducts2 = getComercialProducts();
        if (comercialProducts2 != null && comercialProducts2.size() > 0) {
            for (Map<String, String> basicService : comercialProducts2) {
                if (basicService.containsKey(BLUtils.getCountryISOLowerCase(context))) {
                    if (basicServices.isEmpty()) {
                        basicServices = BLUtils.lowerCaseWithFirstLetter(basicService.get(BLUtils.getCountryISOLowerCase(context)));
                    } else {
                        basicServices = basicServices + "\n" + BLUtils.lowerCaseWithFirstLetter(basicService.get(BLUtils.getCountryISOLowerCase(context)));
                    }
                } else if (basicServices.isEmpty()) {
                    basicServices = BLUtils.lowerCaseWithFirstLetter(basicService.get("default"));
                } else {
                    basicServices = basicServices + "\n" + BLUtils.lowerCaseWithFirstLetter(basicService.get("default"));
                }
            }
        }
        return BLUtils.capitalizeStringAfterLineBreak(basicServices);
    }

    public class ContactData {
        /* access modifiers changed from: private */
        @SerializedName("phoneNumber")
        public String phoneNumber;

        public ContactData() {
        }

        /* access modifiers changed from: package-private */
        public String getPhoneNumber() {
            return this.phoneNumber;
        }
    }

    class Appointment {
        @SerializedName("branchAppointment")
        private String branchAppointment;

        Appointment() {
        }

        /* access modifiers changed from: package-private */
        public String getBranchAppointment() {
            return this.branchAppointment;
        }
    }

    class Schedule {
        @SerializedName("specialDay")
        private List<SpecialDay> specialDay;
        @SerializedName("workingDay")
        private WorkingDay workingDay;

        Schedule() {
        }

        /* access modifiers changed from: package-private */
        public List<SpecialDay> getSpecialDay() {
            if (this.specialDay != null) {
                return new ArrayList(this.specialDay);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public WorkingDay getWorkingDay() {
            return this.workingDay;
        }

        class SpecialDay {
            @SerializedName("date")
            private String date;
            @SerializedName("time")
            private List<String> time;

            SpecialDay() {
            }

            public String getDate() {
                return this.date;
            }

            public List<String> getTime() {
                if (this.time != null) {
                    return new ArrayList(this.time);
                }
                return null;
            }
        }

        class WorkingDay {
            @SerializedName("FRIDAY")
            private List<String> friday;
            @SerializedName("MONDAY")
            private List<String> monday;
            @SerializedName("SATURDAY")
            private List<String> saturday;
            @SerializedName("SUNDAY")
            private List<String> sunday;
            @SerializedName("THURSDAY")
            private List<String> thursday;
            @SerializedName("TUESDAY")
            private List<String> tuesday;
            @SerializedName("WEDNESDAY")
            private List<String> wednesday;

            WorkingDay() {
            }

            /* access modifiers changed from: package-private */
            public List<String> getMonday() {
                if (this.monday != null) {
                    return new ArrayList(this.monday);
                }
                return null;
            }

            /* access modifiers changed from: package-private */
            public List<String> getTuesday() {
                if (this.tuesday != null) {
                    return new ArrayList(this.tuesday);
                }
                return null;
            }

            /* access modifiers changed from: package-private */
            public List<String> getWednesday() {
                if (this.wednesday != null) {
                    return new ArrayList(this.wednesday);
                }
                return null;
            }

            /* access modifiers changed from: package-private */
            public List<String> getThursday() {
                if (this.thursday != null) {
                    return new ArrayList(this.thursday);
                }
                return null;
            }

            /* access modifiers changed from: package-private */
            public List<String> getFriday() {
                if (this.friday != null) {
                    return new ArrayList(this.friday);
                }
                return null;
            }

            /* access modifiers changed from: package-private */
            public List<String> getSaturday() {
                if (this.saturday != null) {
                    return new ArrayList(this.saturday);
                }
                return null;
            }

            /* access modifiers changed from: package-private */
            public List<String> getSunday() {
                if (this.sunday != null) {
                    return new ArrayList(this.sunday);
                }
                return null;
            }
        }
    }
}
