package es.santander.justicia.minisJusticia.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class EnciclopediaItemDTO implements Parcelable {
    public static final Parcelable.Creator<EnciclopediaItemDTO> CREATOR = new Parcelable.Creator<EnciclopediaItemDTO>() {
        public EnciclopediaItemDTO createFromParcel(Parcel in) {
            return new EnciclopediaItemDTO(in);
        }

        public EnciclopediaItemDTO[] newArray(int size) {
            return new EnciclopediaItemDTO[size];
        }
    };
    private String description;
    private String idd;
    private String ide;
    private String level;
    private String link;
    private String parentIde;
    private String version;

    public EnciclopediaItemDTO() {
    }

    public String getIde() {
        return this.ide;
    }

    public void setIde(String ide2) {
        this.ide = ide2;
    }

    public String getIdd() {
        return this.idd;
    }

    public void setIdd(String idd2) {
        this.idd = idd2;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version2) {
        this.version = version2;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link2) {
        this.link = link2;
    }

    public String getParentIde() {
        return this.parentIde;
    }

    public void setParentIde(String parentIde2) {
        this.parentIde = parentIde2;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level2) {
        this.level = level2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public EnciclopediaItemDTO(Parcel in) {
        this.ide = in.readString();
        this.idd = in.readString();
        this.version = in.readString();
        this.link = in.readString();
        this.ide = in.readString();
        this.idd = in.readString();
        this.level = in.readString();
        this.parentIde = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ide);
        dest.writeString(this.idd);
        dest.writeString(this.version);
        dest.writeString(this.link);
        dest.writeString(this.level);
        dest.writeString(this.parentIde);
    }
}
