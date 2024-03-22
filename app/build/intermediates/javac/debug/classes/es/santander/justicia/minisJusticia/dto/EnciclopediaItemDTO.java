package es.santander.justicia.minisJusticia.dto;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import es.santander.justicia.minisJusticia.dto.EnciclopediaItemDTO.1;

public class EnciclopediaItemDTO implements Parcelable {
   private String ide;
   private String idd;
   private String version;
   private String link;
   private String level;
   private String parentIde;
   private String description;
   public static final Creator<EnciclopediaItemDTO> CREATOR = new 1();

   public EnciclopediaItemDTO() {
   }

   public String getIde() {
      return this.ide;
   }

   public void setIde(String ide) {
      this.ide = ide;
   }

   public String getIdd() {
      return this.idd;
   }

   public void setIdd(String idd) {
      this.idd = idd;
   }

   public String getVersion() {
      return this.version;
   }

   public void setVersion(String version) {
      this.version = version;
   }

   public String getLink() {
      return this.link;
   }

   public void setLink(String link) {
      this.link = link;
   }

   public String getParentIde() {
      return this.parentIde;
   }

   public void setParentIde(String parentIde) {
      this.parentIde = parentIde;
   }

   public String getLevel() {
      return this.level;
   }

   public void setLevel(String level) {
      this.level = level;
   }

   public String getDescription() {
      return this.description;
   }

   public void setDescription(String description) {
      this.description = description;
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
