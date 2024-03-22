package es.santander.branchlocator.data;

import com.google.gson.annotations.SerializedName;

public class BLAttrib {
    @SerializedName("code")
    private String mCode;
    @SerializedName("multi")
    private BLMulti mMulti;

    public String getCode() {
        return this.mCode;
    }

    public void setCode(String code) {
        this.mCode = code;
    }

    public BLMulti getMulti() {
        return this.mMulti;
    }

    public void setMulti(BLMulti multi) {
        this.mMulti = multi;
    }
}
