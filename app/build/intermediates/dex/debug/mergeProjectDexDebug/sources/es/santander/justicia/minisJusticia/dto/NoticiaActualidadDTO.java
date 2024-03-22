package es.santander.justicia.minisJusticia.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class NoticiaActualidadDTO implements Parcelable {
    public static final Parcelable.Creator<NoticiaActualidadDTO> CREATOR = new Parcelable.Creator<NoticiaActualidadDTO>() {
        public NoticiaActualidadDTO createFromParcel(Parcel in) {
            return new NoticiaActualidadDTO(in);
        }

        public NoticiaActualidadDTO[] newArray(int size) {
            return new NoticiaActualidadDTO[size];
        }
    };
    private String description;
    private String guid;
    private String link;
    private String pubDate;
    private String pubDateZone;
    private String tituloNoticia;

    public NoticiaActualidadDTO() {
    }

    public String getTituloNoticia() {
        return this.tituloNoticia;
    }

    public void setTituloNoticia(String tituloNoticia2) {
        this.tituloNoticia = tituloNoticia2;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link2) {
        this.link = link2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public String getGuid() {
        return this.guid;
    }

    public void setGuid(String guid2) {
        this.guid = guid2;
    }

    public String getPubDate() {
        return this.pubDate;
    }

    public void setPubDate(String pubDate2) {
        this.pubDate = pubDate2;
    }

    public String getPubDateZone() {
        return this.pubDateZone;
    }

    public void setPubDateZone(String pubDateZone2) {
        this.pubDateZone = pubDateZone2;
    }

    public NoticiaActualidadDTO(Parcel in) {
        this.tituloNoticia = in.readString();
        this.link = in.readString();
        this.description = in.readString();
        this.guid = in.readString();
        this.pubDate = in.readString();
        this.pubDateZone = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tituloNoticia);
        dest.writeString(this.link);
        dest.writeString(this.description);
        dest.writeString(this.guid);
        dest.writeString(this.pubDate);
        dest.writeString(this.pubDateZone);
    }
}
