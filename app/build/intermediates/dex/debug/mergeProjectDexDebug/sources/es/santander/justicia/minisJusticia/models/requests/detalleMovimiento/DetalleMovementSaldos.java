package es.santander.justicia.minisJusticia.models.requests.detalleMovimiento;

import android.os.Parcel;
import android.os.Parcelable;
import org.simpleframework.xml.Element;

public class DetalleMovementSaldos implements Parcelable {
    public static final Parcelable.Creator<DetalleMovementSaldos> CREATOR = new Parcelable.Creator<DetalleMovementSaldos>() {
        public DetalleMovementSaldos createFromParcel(Parcel in) {
            return new DetalleMovementSaldos(in);
        }

        public DetalleMovementSaldos[] newArray(int size) {
            return new DetalleMovementSaldos[size];
        }
    };
    @Element(name = "codmon", required = false)
    private String codmon;
    @Element(name = "jtipomod", required = false)
    private String jtipomod;

    public DetalleMovementSaldos(String codmon2, String jtipomod2) {
        if (codmon2 != null) {
            this.codmon = codmon2;
        }
        if (jtipomod2 != null) {
            this.jtipomod = jtipomod2;
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
