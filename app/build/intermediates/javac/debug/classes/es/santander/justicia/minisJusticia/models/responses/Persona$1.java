package es.santander.justicia.minisJusticia.models.responses;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class Persona$1 implements Creator<Persona> {
   public Persona createFromParcel(Parcel in) {
      return new Persona(in);
   }

   public Persona[] newArray(int size) {
      return new Persona[size];
   }
}
