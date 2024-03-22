package es.santander.justicia.minisJusticia.models.responses;

import android.os.Parcel;
import android.os.Parcelable;
import es.santander.justicia.minisJusticia.models.responses.loginunico.LoginUnicoCentro;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Contrato implements Parcelable {
    public static final Parcelable.Creator<Contrato> CREATOR = new Parcelable.Creator<Contrato>() {
        public Contrato createFromParcel(Parcel in) {
            return new Contrato(in);
        }

        public Contrato[] newArray(int size) {
            return new Contrato[size];
        }
    };
    @Element(name = "CENTRO", required = false)
    private LoginUnicoCentro loginUnicoCentro;
    @Element(name = "NUMERO_DE_CONTRATO", required = false)
    private String numeroDeContrato;
    @Element(name = "PRODUCTO", required = false)
    private String producto;

    public Contrato(@Element(name = "CENTRO", required = false) LoginUnicoCentro loginUnicoCentro2, @Element(name = "PRODUCTO", required = false) String producto2, @Element(name = "NUMERO_DE_CONTRATO", required = false) String numeroDeContrato2) {
        this.loginUnicoCentro = loginUnicoCentro2;
        this.producto = producto2;
        this.numeroDeContrato = numeroDeContrato2;
    }

    protected Contrato(Parcel in) {
        this.loginUnicoCentro = (LoginUnicoCentro) in.readParcelable(LoginUnicoCentro.class.getClassLoader());
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
