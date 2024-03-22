package es.santander.justicia.minisJusticia.dto;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class NoticiaActualidadDTO$1 implements Creator<NoticiaActualidadDTO> {
   public NoticiaActualidadDTO createFromParcel(Parcel in) {
      return new NoticiaActualidadDTO(in);
   }

   public NoticiaActualidadDTO[] newArray(int size) {
      return new NoticiaActualidadDTO[size];
   }
}
