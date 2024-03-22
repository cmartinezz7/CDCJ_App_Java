package es.santander.justicia.minisJusticia.models.responses;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class Contrato$1 implements Creator<Contrato> {
   public Contrato createFromParcel(Parcel in) {
      return new Contrato(in);
   }

   public Contrato[] newArray(int size) {
      return new Contrato[size];
   }
}
