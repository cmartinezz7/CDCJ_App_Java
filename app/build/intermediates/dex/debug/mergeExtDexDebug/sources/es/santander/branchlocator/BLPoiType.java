package es.santander.branchlocator;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

class BLPoiType {
    @SerializedName("code")
    private String code;
    @SerializedName("multi")
    private Map<String, String> multi;

    BLPoiType() {
    }

    public String getCode() {
        return this.code.toLowerCase().trim();
    }

    public void setCode(String code2) {
        this.code = code2;
    }

    public Map<String, String> getMulti() {
        return new HashMap(this.multi);
    }

    public void setMulti(HashMap<String, String> multi2) {
        this.multi = new HashMap(multi2);
    }

    public String getTranslationString(Context context) {
        String countryISO = BLUtils.getCountryISOLowerCase(context);
        Map<String, String> map = this.multi;
        if (map == null || map.size() == 0) {
            return "";
        }
        if (this.multi.containsKey(countryISO)) {
            return this.multi.get(countryISO);
        }
        return this.multi.get("default");
    }
}
