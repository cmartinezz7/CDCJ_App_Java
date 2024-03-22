package es.santander.branchlocator;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class BLPreferencesManager {
    private static final String FILTER_DATA = "filters";
    private static final String PREF_NAME = "branch_locator_preferences";
    public static LatLng currentLocation = null;
    public static List<BLFeesResponse> fees = null;
    public static boolean isUserLogged = false;
    private static BLPreferencesManager sInstance;
    public static BLPoi selectedBLPOI = null;
    private final SharedPreferences mPref;

    private BLPreferencesManager(Context context) {
        this.mPref = context.getSharedPreferences(PREF_NAME, 0);
    }

    public static synchronized BLPreferencesManager getInstance(Context context) {
        BLPreferencesManager bLPreferencesManager;
        synchronized (BLPreferencesManager.class) {
            if (sInstance == null) {
                sInstance = new BLPreferencesManager(context);
            }
            bLPreferencesManager = sInstance;
        }
        return bLPreferencesManager;
    }

    public static BLFeesResponse getFeeResponse(String countryId) {
        List<BLFeesResponse> list = fees;
        if (list == null) {
            return null;
        }
        for (BLFeesResponse feeResponse : list) {
            if (feeResponse.getCountryId().equals(countryId)) {
                return feeResponse;
            }
        }
        return null;
    }

    public static void addFee(BLFeesResponse fee) {
        if (fees == null) {
            fees = new ArrayList();
        }
        fees.add(fee);
    }

    public void saveFilterData(List<BLFilter> filters) {
        if (filters != null || !filters.isEmpty()) {
            clear();
            this.mPref.edit().putString(FILTER_DATA, new Gson().toJson((Object) filters)).apply();
        }
    }

    public List<BLFilter> getFilterData() {
        String filtersString = this.mPref.getString(FILTER_DATA, "");
        if (!filtersString.isEmpty()) {
            return (List) new Gson().fromJson(filtersString, new TypeToken<List<BLFilter>>() {
            }.getType());
        }
        return null;
    }

    public void remove(String key) {
        this.mPref.edit().remove(key).apply();
    }

    public boolean clear() {
        return this.mPref.edit().clear().commit();
    }
}
