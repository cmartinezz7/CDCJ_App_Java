package es.santander.branchlocator;

import com.google.gson.annotations.SerializedName;

class BLFee {
    @SerializedName("currency")
    private String currency;
    @SerializedName("surcharge")
    private String fee;
    @SerializedName("idTypeSurcharge")
    private String id;

    BLFee() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id2) {
        this.id = id2;
    }

    public String getFee() {
        return this.fee;
    }

    public void setFee(String fee2) {
        this.fee = fee2;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency2) {
        this.currency = currency2;
    }
}
