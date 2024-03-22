package es.santander.justicia.minisJusticia.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class EnciclopediaParentItemDTO implements Parcelable {
    public static final Parcelable.Creator<EnciclopediaParentItemDTO> CREATOR = new Parcelable.Creator<EnciclopediaParentItemDTO>() {
        public EnciclopediaParentItemDTO createFromParcel(Parcel in) {
            return new EnciclopediaParentItemDTO(in);
        }

        public EnciclopediaParentItemDTO[] newArray(int size) {
            return new EnciclopediaParentItemDTO[size];
        }
    };
    private String ide;
    private String level;
    private String parentIDE;
    private String title;

    public EnciclopediaParentItemDTO() {
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level2) {
        this.level = level2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getIde() {
        return this.ide;
    }

    public void setIde(String ide2) {
        this.ide = ide2;
    }

    public String getParentIDE() {
        return this.parentIDE;
    }

    public void setParentIDE(String parentIDE2) {
        this.parentIDE = parentIDE2;
    }

    public int describeContents() {
        return 0;
    }

    public EnciclopediaParentItemDTO(Parcel in) {
        this.ide = in.readString();
        this.title = in.readString();
        this.parentIDE = in.readString();
        this.level = in.readString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ide);
        dest.writeString(this.title);
        dest.writeString(this.parentIDE);
        dest.writeString(this.level);
    }
}
