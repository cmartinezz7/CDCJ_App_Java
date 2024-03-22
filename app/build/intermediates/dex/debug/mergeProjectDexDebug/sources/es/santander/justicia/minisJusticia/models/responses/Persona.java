package es.santander.justicia.minisJusticia.models.responses;

import android.os.Parcel;
import android.os.Parcelable;
import org.simpleframework.xml.Element;

public class Persona implements Parcelable {
    public static final Parcelable.Creator<Persona> CREATOR = new Parcelable.Creator<Persona>() {
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };
    @Element(name = "CODIGO_DE_PERSONA", required = false)
    private String codigoPersona;
    @Element(name = "TIPO_DE_PERSONA", required = false)
    private String tipoPersona;

    protected Persona(Parcel in) {
        this.tipoPersona = in.readString();
        this.codigoPersona = in.readString();
    }

    public Persona(@Element(name = "TIPO_DE_PERSONA", required = false) String tipoPersona2, @Element(name = "CODIGO_DE_PERSONA", required = false) String codigoPersona2) {
        this.tipoPersona = tipoPersona2;
        this.codigoPersona = codigoPersona2;
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
