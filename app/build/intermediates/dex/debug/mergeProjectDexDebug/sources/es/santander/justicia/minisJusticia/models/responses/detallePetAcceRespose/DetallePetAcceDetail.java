package es.santander.justicia.minisJusticia.models.responses.detallePetAcceRespose;

import org.simpleframework.xml.Element;

public class DetallePetAcceDetail {
    @Element(name = "anioApertura", required = false)
    private String anioApertura;
    @Element(name = "codCompletoExpediente", required = false)
    private String codCompletoExpediente;
    @Element(name = "codDocumento", required = false)
    private String codDocumento;
    @Element(name = "codEstadoActualExp", required = false)
    private String codEstadoActualExp;
    @Element(name = "codEstadoPeticion", required = false)
    private String codEstadoPeticion;
    @Element(name = "codJuzDest", required = false)
    private String codJuzDest;
    @Element(name = "codJuzOri", required = false)
    private String codJuzOri;
    @Element(name = "codMotivoSolicitud", required = false)
    private String codMotivoSolicitud;
    @Element(name = "codProced", required = false)
    private String codProced;
    @Element(name = "codTipoDocumento", required = false)
    private String codTipoDocumento;
    @Element(name = "codUsuarioAutoriza", required = false)
    private String codUsuarioAutoriza;
    @Element(name = "comentariosSecretario", required = false)
    private String comentariosSecretario;
    @Element(name = "contadorDeAccesos", required = false)
    private String contadorDeAccesos;
    @Element(name = "desEstadoActualExp", required = false)
    private String desEstadoActualExp;
    @Element(name = "desEstadoPeticion", required = false)
    private String desEstadoPeticion;
    @Element(name = "desMotivoSolicitud", required = false)
    private String desMotivoSolicitud;
    @Element(name = "fecDeAceptacion", required = false)
    private String fecDeAceptacion;
    @Element(name = "fecDeBaja", required = false)
    private String fecDeBaja;
    @Element(name = "fecDeDenegacion", required = false)
    private String fecDeDenegacion;
    @Element(name = "fecDeLaPeticion", required = false)
    private String fecDeLaPeticion;
    @Element(name = "nombre", required = false)
    private String nombre;
    @Element(name = "numExpediente", required = false)
    private String numExpediente;
    @Element(name = "reactivarPeticion", required = false)
    private String reactivarPeticion;

    public String getAnioApertura() {
        return this.anioApertura;
    }

    public String getCodCompletoExpediente() {
        return this.codCompletoExpediente;
    }

    public String getCodDocumento() {
        return this.codDocumento;
    }

    public String getCodEstadoActualExp() {
        return this.codEstadoActualExp;
    }

    public String getCodEstadoPeticion() {
        return this.codEstadoPeticion;
    }

    public String getCodJuzDest() {
        return this.codJuzDest;
    }

    public String getCodJuzOri() {
        return this.codJuzOri;
    }

    public String getCodMotivoSolicitud() {
        return this.codMotivoSolicitud;
    }

    public String getCodProced() {
        return this.codProced;
    }

    public String getCodTipoDocumento() {
        return this.codTipoDocumento;
    }

    public String getCodUsuarioAutoriza() {
        return this.codUsuarioAutoriza;
    }

    public String getComentariosSecretario() {
        return this.comentariosSecretario;
    }

    public String getContadorDeAccesos() {
        return this.contadorDeAccesos;
    }

    public String getDesEstadoActualExp() {
        return this.desEstadoActualExp;
    }

    public String getDesEstadoPeticion() {
        return this.desEstadoPeticion;
    }

    public String getDesMotivoSolicitud() {
        return this.desMotivoSolicitud;
    }

    public String getFecDeAceptacion() {
        return this.fecDeAceptacion;
    }

    public String getFecDeBaja() {
        return this.fecDeBaja;
    }

    public String getFecDeDenegacion() {
        return this.fecDeDenegacion;
    }

    public String getFecDeLaPeticion() {
        return this.fecDeLaPeticion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getNumExpediente() {
        return this.numExpediente;
    }

    public String getReactivarPeticion() {
        return this.reactivarPeticion;
    }
}
