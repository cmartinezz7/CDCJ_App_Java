package es.santander.justicia.minisJusticia.dto;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class EnciclopediaItemDTO$1 implements Creator<EnciclopediaItemDTO> {
   public EnciclopediaItemDTO createFromParcel(Parcel in) {
      return new EnciclopediaItemDTO(in);
   }

   public EnciclopediaItemDTO[] newArray(int size) {
      return new EnciclopediaItemDTO[size];
   }
}
