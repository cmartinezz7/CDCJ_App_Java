package es.santander.justicia.minisJusticia.models.responses.loginunico;

import android.os.Parcel;
import android.os.Parcelable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class LoginUnicoCentro implements Parcelable {
    public static final Parcelable.Creator<LoginUnicoCentro> CREATOR = new Parcelable.Creator<LoginUnicoCentro>() {
        public LoginUnicoCentro createFromParcel(Parcel in) {
            return new LoginUnicoCentro(in);
        }

        public LoginUnicoCentro[] newArray(int size) {
            return new LoginUnicoCentro[size];
        }
    };
    @Element(name = "CENTRO", required = false)
    private String centro;
    @Element(name = "EMPRESA", required = false)
    private String empresa;

    public LoginUnicoCentro(@Element(name = "EMPRESA", required = false) String empresa2, @Element(name = "CENTRO", required = false) String centro2) {
        this.empresa = empresa2;
        this.centro = centro2;
    }

    public LoginUnicoCentro() {
    }

    protected LoginUnicoCentro(Parcel in) {
        this.empresa = in.readString();
        this.centro = in.readString();
    }

    public String getEmpresa() {
        return this.empresa;
    }

    public String getCentro() {
        return this.centro;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.empresa);
        parcel.writeString(this.centro);
    }
}
