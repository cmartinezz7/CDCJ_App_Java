package es.santander.justicia.minisJusticia.dto;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class EnciclopediaParentItemDTO$1 implements Creator<EnciclopediaParentItemDTO> {
   public EnciclopediaParentItemDTO createFromParcel(Parcel in) {
      return new EnciclopediaParentItemDTO(in);
   }

   public EnciclopediaParentItemDTO[] newArray(int size) {
      return new EnciclopediaParentItemDTO[size];
   }
}
