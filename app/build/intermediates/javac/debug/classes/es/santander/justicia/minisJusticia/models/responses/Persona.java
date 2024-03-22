package es.santander.justicia.minisJusticia.models.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import es.santander.justicia.minisJusticia.models.responses.Persona.1;
import org.simpleframework.xml.Element;

public class Persona implements Parcelable {
   @Element(
      name = "TIPO_DE_PERSONA",
      required = false
   )
   private String tipoPersona;
   @Element(
      name = "CODIGO_DE_PERSONA",
      required = false
   )
   private String codigoPersona;
   public static final Creator<Persona> CREATOR = new 1();

   protected Persona(Parcel in) {
      this.tipoPersona = in.readString();
      this.codigoPersona = in.readString();
   }

   public Persona(@Element(name = "TIPO_DE_PERSONA",required = false) String tipoPersona, @Element(name = "CODIGO_DE_PERSONA",required = false) String codigoPersona) {
      this.tipoPersona = tipoPersona;
      this.codigoPersona = codigoPersona;
   }

   public Persona() {
   }

   public String getTipoPersona() {
      return this.tipoPersona;
   }

   public String getCodigoPersona() {
      return this.codigoPersona;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel parcel, int i) {
      parcel.writeString(this.tipoPersona);
      parcel.writeString(this.codigoPersona);
   }
}
