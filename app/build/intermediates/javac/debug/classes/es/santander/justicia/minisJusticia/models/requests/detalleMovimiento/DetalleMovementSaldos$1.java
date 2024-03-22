package es.santander.justicia.minisJusticia.models.requests.detalleMovimiento;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class DetalleMovementSaldos$1 implements Creator<DetalleMovementSaldos> {
   public DetalleMovementSaldos createFromParcel(Parcel in) {
      return new DetalleMovementSaldos(in);
   }

   public DetalleMovementSaldos[] newArray(int size) {
      return new DetalleMovementSaldos[size];
   }
}
