package es.santander.justicia.minisJusticia.models.requests.listaMovimientos;

import android.os.Parcel;
import android.os.Parcelable;
import es.santander.justicia.utils.CommonUtils;
import org.simpleframework.xml.Element;

public class DatosExpedienteDetail implements Parcelable {
    public static final Parcelable.Creator<DatosExpedienteDetail> CREATOR = new Parcelable.Creator<DatosExpedienteDetail>() {
        public DatosExpedienteDetail createFromParcel(Parcel in) {
            return new DatosExpedienteDetail(in);
        }

        public DatosExpedienteDetail[] newArray(int size) {
            return new DatosExpedienteDetail[size];
        }
    };
    @Element(name = "janoapex", required = false)
    private String janoapex;
    @Element(name = "jnumexp", required = false)
    private String jnumexp;
    @Element(name = "jproced", required = false)
    private String jproced;
    @Element(name = "juzga", required = false)
    private String juzga;
    @Element(name = "juzgori", required = false)
    private String juzgori;
    private String numComplete;
    private String primov;
    private String ultmov;

    public DatosExpedienteDetail(String janoapex2, String jnumexp2, String jproced2, String juzga2, String juzgori2, String primov2, String ultmov2) {
        this.janoapex = janoapex2;
        this.jnumexp = jnumexp2;
        this.jproced = jproced2;
        this.juzga = juzga2;
        this.juzgori = juzgori2;
        this.primov = primov2;
        this.ultmov = ultmov2;
        this.numComplete = CommonUtils.formatExpedient(juzga2, juzgori2, jproced2, jnumexp2, janoapex2);
    }

    public DatosExpedienteDetail(String janoapex2, String jnumexp2, String jproced2, String juzga2, String juzgori2) {
        this.janoapex = janoapex2;
        this.jnumexp = jnumexp2;
        this.jproced = jproced2;
        this.juzga = juzga2;
        this.juzgori = juzgori2;
        this.numComplete = CommonUtils.formatExpedient(juzga2, juzgori2, jproced2, jnumexp2, janoapex2);
    }

    protected DatosExpedienteDetail(Parcel in) {
        this.janoapex = in.readString();
        this.jnumexp = in.readString();
        this.jproced = in.readString();
        this.juzga = in.readString();
        this.juzgori = in.readString();
        this.primov = in.readString();
        this.ultmov = in.readString();
        this.numComplete = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.janoapex);
        dest.writeString(this.jnumexp);
        dest.writeString(this.jproced);
        dest.writeString(this.juzga);
        dest.writeString(this.juzgori);
        dest.writeString(this.primov);
        dest.writeString(this.ultmov);
        dest.writeString(this.numComplete);
    }

    public String getJanoapex() {
        return this.janoapex;
    }

    public String getJnumexp() {
        return this.jnumexp;
    }

    public String getJproced() {
        return this.jproced;
    }

    public String getJuzga() {
        return this.juzga;
    }

    public String getJuzgori() {
        return this.juzgori;
    }

    public String getNumComplete() {
        return this.numComplete;
    }

    public String getPriMov() {
        return this.primov;
    }

    public String getUltMov() {
        return this.ultmov;
    }
}
