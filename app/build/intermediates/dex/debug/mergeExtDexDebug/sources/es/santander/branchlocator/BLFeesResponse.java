package es.santander.branchlocator;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

class BLFeesResponse {
    @SerializedName("countryId")
    private String countryId;
    @SerializedName("surcharges")
    private List<BLFee> fees;
    @SerializedName("id")
    private String id;

    BLFeesResponse() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id2) {
        this.id = id2;
    }

    public String getCountryId() {
        return this.countryId;
    }

    public void setCountryId(String countryId2) {
        this.countryId = countryId2;
    }

    public List<BLFee> getFees() {
        if (this.fees != null) {
            return new ArrayList(this.fees);
        }
        return null;
    }

    public void setFees(List<BLFee> fees2) {
        this.fees = new ArrayList(fees2);
    }
}
