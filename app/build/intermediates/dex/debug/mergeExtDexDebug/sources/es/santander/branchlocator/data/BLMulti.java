package es.santander.branchlocator.data;

import com.google.gson.annotations.SerializedName;

public class BLMulti {
    @SerializedName("default")
    private String mDefault;
    @SerializedName("es")
    private String mEs;

    public String getDefault() {
        return this.mDefault;
    }

    public void setDefault(String mDefault2) {
        this.mDefault = mDefault2;
    }

    public String getEs() {
        return this.mEs;
    }

    public void setEs(String es2) {
        this.mEs = es2;
    }
}
