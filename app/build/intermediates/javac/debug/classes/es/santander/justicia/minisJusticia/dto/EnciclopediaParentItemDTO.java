package es.santander.justicia.minisJusticia.dto;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import es.santander.justicia.minisJusticia.dto.EnciclopediaParentItemDTO.1;

public class EnciclopediaParentItemDTO implements Parcelable {
   private String title;
   private String ide;
   private String parentIDE;
   private String level;
   public static final Creator<EnciclopediaParentItemDTO> CREATOR = new 1();

   public EnciclopediaParentItemDTO() {
   }

   public String getLevel() {
      return this.level;
   }

   public void setLevel(String level) {
      this.level = level;
   }

   public String getTitle() {
      return this.title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getIde() {
      return this.ide;
   }

   public void setIde(String ide) {
      this.ide = ide;
   }

   public String getParentIDE() {
      return this.parentIDE;
   }

   public void setParentIDE(String parentIDE) {
      this.parentIDE = parentIDE;
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
