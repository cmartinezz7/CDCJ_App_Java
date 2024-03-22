package es.santander.justicia.minisJusticia.models.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import es.santander.justicia.minisJusticia.models.responses.Contrato.1;
import es.santander.justicia.minisJusticia.models.responses.loginunico.LoginUnicoCentro;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(
   strict = false
)
public class Contrato implements Parcelable {
   @Element(
      name = "CENTRO",
      required = false
   )
   private LoginUnicoCentro loginUnicoCentro;
   @Element(
      name = "PRODUCTO",
      required = false
   )
   private String producto;
   @Element(
      name = "NUMERO_DE_CONTRATO",
      required = false
   )
   private String numeroDeContrato;
   public static final Creator<Contrato> CREATOR = new 1();

   public Contrato(@Element(name = "CENTRO",required = false) LoginUnicoCentro loginUnicoCentro, @Element(name = "PRODUCTO",required = false) String producto, @Element(name = "NUMERO_DE_CONTRATO",required = false) String numeroDeContrato) {
      this.loginUnicoCentro = loginUnicoCentro;
      this.producto = producto;
      this.numeroDeContrato = numeroDeContrato;
   }

   protected Contrato(Parcel in) {
      this.loginUnicoCentro = (LoginUnicoCentro)in.readParcelable(LoginUnicoCentro.class.getClassLoader());
      this.producto = in.readString();
      this.numeroDeContrato = in.readString();
   }

   public LoginUnicoCentro getLoginUnicoCentro() {
      return this.loginUnicoCentro;
   }

   public String getProducto() {
      return this.producto;
   }

   public String getNumeroDeContrato() {
      return this.numeroDeContrato;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel parcel, int i) {
      parcel.writeParcelable(this.loginUnicoCentro, i);
      parcel.writeString(this.producto);
      parcel.writeString(this.numeroDeContrato);
   }
}
