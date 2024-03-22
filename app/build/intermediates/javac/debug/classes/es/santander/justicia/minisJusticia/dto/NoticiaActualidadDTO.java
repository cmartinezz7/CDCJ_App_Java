package es.santander.justicia.minisJusticia.dto;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO.1;

public class NoticiaActualidadDTO implements Parcelable {
   private String tituloNoticia;
   private String link;
   private String description;
   private String guid;
   private String pubDate;
   private String pubDateZone;
   public static final Creator<NoticiaActualidadDTO> CREATOR = new 1();

   public NoticiaActualidadDTO() {
   }

   public String getTituloNoticia() {
      return this.tituloNoticia;
   }

   public void setTituloNoticia(String tituloNoticia) {
      this.tituloNoticia = tituloNoticia;
   }

   public String getLink() {
      return this.link;
   }

   public void setLink(String link) {
      this.link = link;
   }

   public String getDescription() {
      return this.description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getGuid() {
      return this.guid;
   }

   public void setGuid(String guid) {
      this.guid = guid;
   }

   public String getPubDate() {
      return this.pubDate;
   }

   public void setPubDate(String pubDate) {
      this.pubDate = pubDate;
   }

   public String getPubDateZone() {
      return this.pubDateZone;
   }

   public void setPubDateZone(String pubDateZone) {
      this.pubDateZone = pubDateZone;
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
