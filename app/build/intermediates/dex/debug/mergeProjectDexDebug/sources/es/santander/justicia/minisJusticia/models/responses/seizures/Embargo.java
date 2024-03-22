package es.santander.justicia.minisJusticia.models.responses.seizures;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Embargo implements Parent<EmbargoDetail> {
    @Element(name = "anoAperturaExpediente", required = false)
    private String anoAperturaExpediente;
    @Element(name = "apellido1PersonaEmbargo", required = false)
    private String apellido1PersonaEmbargo;
    @Element(name = "apellido2PersonaEmbargo", required = false)
    private String apellido2PersonaEmbargo;
    @Element(name = "codClaveEmbargo", required = false)
    private String codClaveEmbargo;
    @Element(name = "codigoDocumentoIdentidad", required = false)
    private String codigoDocumentoIdentidad;
    @Element(name = "codigoEstado", required = false)
    private String codigoEstado;
    @Element(name = "codigoExpediente", required = false)
    private String codigoExpediente;
    @Element(name = "codigoJuzgadoDestino", required = false)
    private String codigoJuzgadoDestino;
    @Element(name = "codigoJuzgadoOrigen", required = false)
    private String codigoJuzgadoOrigen;
    @Element(name = "codigoMoneda", required = false)
    private String codigoMoneda;
    @Element(name = "codigoProcedimiento", required = false)
    private String codigoProcedimiento;
    @Element(name = "codigoTipoDocumento", required = false)
    private String codigoTipoDocumento;
    @Element(name = "codigoTipoEmbargo", required = false)
    private String codigoTipoEmbargo;
    @Element(name = "codigoUnidadOrganizativa", required = false)
    private String codigoUnidadOrganizativa;
    @Element(name = "codigoUsuarioAlta", required = false)
    private String codigoUsuarioAlta;
    @Element(name = "codigoUsuarioModificacion", required = false)
    private String codigoUsuarioModificacion;
    @Element(name = "descEstado", required = false)
    private String descEstado;
    @Element(name = "descTipoEmbargo", required = false)
    private String descTipoEmbargo;
    public ArrayList<EmbargoDetail> embargoDetails;
    @Element(name = "expediente", required = false)
    private String expediente;
    @Element(name = "fechaAltaRegistro", required = false)
    private String fechaAltaRegistro;
    @Element(name = "fechaModificacionRegistro", required = false)
    private String fechaModificacionRegistro;
    @Element(name = "importeEmbargadoHastaFecha", required = false)
    private String importeEmbargadoHastaFecha;
    @Element(name = "importeTotalEmbargo", required = false)
    private String importeTotalEmbargo;
    @Element(name = "indicadorTipoUsuario", required = false)
    private String indicadorTipoUsuario;
    @Element(name = "nombrePersonaEmbargo", required = false)
    private String nombrePersonaEmbargo;
    @Element(name = "numeroEmbargo", required = false)
    private String numeroEmbargo;
    @Element(name = "numeroExpediente", required = false)
    private String numeroExpediente;
    @Element(name = "numeroOrden", required = false)
    private String numeroOrden;

    public String getAnoAperturaExpediente() {
        return this.anoAperturaExpediente;
    }

    public String getApellido1PersonaEmbargo() {
        return this.apellido1PersonaEmbargo;
    }

    public String getApellido2PersonaEmbargo() {
        return this.apellido2PersonaEmbargo;
    }

    public String getCodClaveEmbargo() {
        return this.codClaveEmbargo;
    }

    public String getCodigoDocumentoIdentidad() {
        return this.codigoDocumentoIdentidad;
    }

    public String getCodigoEstado() {
        return this.codigoEstado;
    }

    public String getCodigoExpediente() {
        return this.codigoExpediente;
    }

    public String getCodigoJuzgadoDestino() {
        return this.codigoJuzgadoDestino;
    }

    public String getCodigoJuzgadoOrigen() {
        return this.codigoJuzgadoOrigen;
    }

    public String getCodigoMoneda() {
        return this.codigoMoneda;
    }

    public String getCodigoProcedimiento() {
        return this.codigoProcedimiento;
    }

    public String getCodigoTipoDocumento() {
        return this.codigoTipoDocumento;
    }

    public String getCodigoTipoEmbargo() {
        return this.codigoTipoEmbargo;
    }

    public String getCodigoUnidadOrganizativa() {
        return this.codigoUnidadOrganizativa;
    }

    public String getCodigoUsuarioAlta() {
        return this.codigoUsuarioAlta;
    }

    public String getCodigoUsuarioModificacion() {
        return this.codigoUsuarioModificacion;
    }

    public String getDescEstado() {
        return this.descEstado;
    }

    public String getDescTipoEmbargo() {
        return this.descTipoEmbargo;
    }

    public String getExpediente() {
        return this.expediente;
    }

    public String getFechaAltaRegistro() {
        return this.fechaAltaRegistro;
    }

    public String getFechaModificacionRegistro() {
        return this.fechaModificacionRegistro;
    }

    public String getImporteEmbargadoHastaFecha() {
        return this.importeEmbargadoHastaFecha;
    }

    public String getImporteTotalEmbargo() {
        return this.importeTotalEmbargo;
    }

    public String getIndicadorTipoUsuario() {
        return this.indicadorTipoUsuario;
    }

    public String getNombrePersonaEmbargo() {
        return this.nombrePersonaEmbargo;
    }

    public String getNumeroEmbargo() {
        return this.numeroEmbargo;
    }

    public String getNumeroExpediente() {
        return this.numeroExpediente;
    }

    public String getNumeroOrden() {
        return this.numeroOrden;
    }

    public void addEmbargoDetails(EmbargoDetail embargoDetail) {
        if (this.embargoDetails == null) {
            this.embargoDetails = new ArrayList<>();
        }
        this.embargoDetails.add(embargoDetail);
    }

    public List<EmbargoDetail> getChildList() {
        return this.embargoDetails;
    }

    public boolean isInitiallyExpanded() {
        return false;
    }
}
