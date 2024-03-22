package es.santander.justicia.minisJusticia.models.requests.detalleMovimiento;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import es.santander.justicia.minisJusticia.models.requests.detalleMovimiento.DetalleMovementSaldos.1;
import org.simpleframework.xml.Element;

public class DetalleMovementSaldos implements Parcelable {
   @Element(
      name = "codmon",
      required = false
   )
   private String codmon;
   @Element(
      name = "jtipomod",
      required = false
   )
   private String jtipomod;
   public static final Creator<DetalleMovementSaldos> CREATOR = new 1();

   public DetalleMovementSaldos(String codmon, String jtipomod) {
      if (codmon != null) {
         this.codmon = codmon;
      }

      if (jtipomod != null) {
         this.jtipomod = jtipomod;
      }

   }

   protected DetalleMovementSaldos(Parcel in) {
      this.codmon = in.readString();
      this.jtipomod = in.readString();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.codmon);
      dest.writeString(this.jtipomod);
   }
}
