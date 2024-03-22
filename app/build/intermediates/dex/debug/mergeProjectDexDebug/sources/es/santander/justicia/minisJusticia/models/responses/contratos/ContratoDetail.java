package es.santander.justicia.minisJusticia.models.responses.contratos;

import android.os.Parcel;
import android.os.Parcelable;
import es.santander.justicia.minisJusticia.models.responses.Contrato;
import es.santander.justicia.minisJusticia.models.responses.Persona;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class ContratoDetail implements Parcelable {
    public static final Parcelable.Creator<ContratoDetail> CREATOR = new Parcelable.Creator<ContratoDetail>() {
        public ContratoDetail createFromParcel(Parcel in) {
            return new ContratoDetail(in);
        }

        public ContratoDetail[] newArray(int size) {
            return new ContratoDetail[size];
        }
    };
    @Element(name = "alias", required = false)
    private String alias;
    @Element(name = "codDocumento", required = false)
    private String codDocumento;
    @Element(name = "contrato", required = false)
    private Contrato contrato;
    @Element(name = "fechaAlta", required = false)
    private String fechaAlta;
    @Element(name = "fechaBaja", required = false)
    private String fechaBaja;
    @Element(name = "fechaUltimoAcceso", required = false)
    private String fechaUltimoAcceso;
    @Element(name = "indOperativoConsultivo", required = false)
    private String indOperativoConsultivo;
    @Element(name = "nombreEmpresa", required = false)
    private String nombreEmpresa;
    @Element(name = "persona", required = false)
    private Persona persona;
    @Element(name = "tipoDocumento", required = false)
    private String tipoDocumento;
    @Element(name = "usuarioInternoEmp", required = false)
    private String usuarioInternoEmp;

    public ContratoDetail(@Element(name = "contrato", required = false) Contrato contrato2, @Element(name = "usuarioInternoEmp", required = false) String usuarioInternoEmp2, @Element(name = "alias", required = false) String alias2, @Element(name = "indOperativoConsultivo", required = false) String indOperativoConsultivo2, @Element(name = "tipoDocumento", required = false) String tipoDocumento2, @Element(name = "codDocumento", required = false) String codDocumento2, @Element(name = "persona", required = false) Persona persona2, @Element(name = "nombreEmpresa", required = false) String nombreEmpresa2, @Element(name = "fechaAlta", required = false) String fechaAlta2, @Element(name = "fechaBaja", required = false) String fechaBaja2, @Element(name = "fechaUltimoAcceso", required = false) String fechaUltimoAcceso2) {
        this.contrato = contrato2;
        this.usuarioInternoEmp = usuarioInternoEmp2;
        this.alias = alias2;
        this.indOperativoConsultivo = indOperativoConsultivo2;
        this.tipoDocumento = tipoDocumento2;
        this.codDocumento = codDocumento2;
        this.persona = persona2;
        this.nombreEmpresa = nombreEmpresa2;
        this.fechaAlta = fechaAlta2;
        this.fechaBaja = fechaBaja2;
        this.fechaUltimoAcceso = fechaUltimoAcceso2;
    }

    public ContratoDetail() {
    }

    protected ContratoDetail(Parcel in) {
        this.contrato = (Contrato) in.readParcelable(Contrato.class.getClassLoader());
        this.usuarioInternoEmp = in.readString();
        this.alias = in.readString();
        this.indOperativoConsultivo = in.readString();
        this.tipoDocumento = in.readString();
        this.codDocumento = in.readString();
        this.persona = (Persona) in.readParcelable(Persona.class.getClassLoader());
        this.nombreEmpresa = in.readString();
        this.fechaAlta = in.readString();
        this.fechaBaja = in.readString();
        this.fechaUltimoAcceso = in.readString();
    }

    public Contrato getContrato() {
        return this.contrato;
    }

    public String getUsuarioInternoEmp() {
        return this.usuarioInternoEmp;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getIndOperativoConsultivo() {
        return this.indOperativoConsultivo;
    }

    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public String getCodDocumento() {
        return this.codDocumento;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }

    public String getFechaAlta() {
        return this.fechaAlta;
    }

    public String getFechaBaja() {
        return this.fechaBaja;
    }

    public String getFechaUltimoAcceso() {
        return this.fechaUltimoAcceso;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.contrato, i);
        parcel.writeString(this.usuarioInternoEmp);
        parcel.writeString(this.alias);
        parcel.writeString(this.indOperativoConsultivo);
        parcel.writeString(this.tipoDocumento);
        parcel.writeString(this.codDocumento);
        parcel.writeParcelable(this.persona, i);
        parcel.writeString(this.nombreEmpresa);
        parcel.writeString(this.fechaAlta);
        parcel.writeString(this.fechaBaja);
        parcel.writeString(this.fechaUltimoAcceso);
    }
}
