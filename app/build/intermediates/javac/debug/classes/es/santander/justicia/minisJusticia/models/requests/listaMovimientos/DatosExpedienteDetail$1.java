package es.santander.justicia.minisJusticia.models.requests.listaMovimientos;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class DatosExpedienteDetail$1 implements Creator<DatosExpedienteDetail> {
   public DatosExpedienteDetail createFromParcel(Parcel in) {
      return new DatosExpedienteDetail(in);
   }

   public DatosExpedienteDetail[] newArray(int size) {
      return new DatosExpedienteDetail[size];
   }
}
