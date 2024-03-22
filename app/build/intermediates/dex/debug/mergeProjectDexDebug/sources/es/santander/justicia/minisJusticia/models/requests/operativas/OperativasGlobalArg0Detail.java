package es.santander.justicia.minisJusticia.models.requests.operativas;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class OperativasGlobalArg0Detail {
    @Element(name = "anioApertura", required = false)
    private int anioApertura;
    @Element(name = "apellido1", required = false)
    private String apellido1;
    @Element(name = "apellido2", required = false)
    private String apellido2;
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
    private int contadorDeAccesos;
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
    @Element(name = "firma", required = false)
    private String firma;
    @Element(name = "nombre", required = false)
    private String nombre;
    @Element(name = "numExpediente", required = false)
    private String numExpediente;
    @Element(name = "reactivarPeticion", required = false)
    private String reactivarPeticion;

    public int getAnioApertura() {
        return this.anioApertura;
    }

    public String getApellido1() {
        return this.apellido1;
    }

    public String getApellido2() {
        return this.apellido2;
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

    public int getContadorDeAccesos() {
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

    public String getFirma() {
        return this.firma;
    }

    public void setAnioApertura(int anioApertura2) {
        this.anioApertura = anioApertura2;
    }

    public void setApellido1(String apellido12) {
        this.apellido1 = apellido12;
    }

    public void setApellido2(String apellido22) {
        this.apellido2 = apellido22;
    }

    public void setCodCompletoExpediente(String codCompletoExpediente2) {
        this.codCompletoExpediente = codCompletoExpediente2;
    }

    public void setCodDocumento(String codDocumento2) {
        this.codDocumento = codDocumento2;
    }

    public void setCodEstadoActualExp(String codEstadoActualExp2) {
        this.codEstadoActualExp = codEstadoActualExp2;
    }

    public void setCodEstadoPeticion(String codEstadoPeticion2) {
        this.codEstadoPeticion = codEstadoPeticion2;
    }

    public void setCodJuzDest(String codJuzDest2) {
        this.codJuzDest = codJuzDest2;
    }

    public void setCodJuzOri(String codJuzOri2) {
        this.codJuzOri = codJuzOri2;
    }

    public void setCodMotivoSolicitud(String codMotivoSolicitud2) {
        this.codMotivoSolicitud = codMotivoSolicitud2;
    }

    public void setCodProced(String codProced2) {
        this.codProced = codProced2;
    }

    public void setCodTipoDocumento(String codTipoDocumento2) {
        this.codTipoDocumento = codTipoDocumento2;
    }

    public void setCodUsuarioAutoriza(String codUsuarioAutoriza2) {
        this.codUsuarioAutoriza = codUsuarioAutoriza2;
    }

    public void setComentariosSecretario(String comentariosSecretario2) {
        this.comentariosSecretario = comentariosSecretario2;
    }

    public void setContadorDeAccesos(int contadorDeAccesos2) {
        this.contadorDeAccesos = contadorDeAccesos2;
    }

    public void setDesEstadoActualExp(String desEstadoActualExp2) {
        this.desEstadoActualExp = desEstadoActualExp2;
    }

    public void setDesEstadoPeticion(String desEstadoPeticion2) {
        this.desEstadoPeticion = desEstadoPeticion2;
    }

    public void setDesMotivoSolicitud(String desMotivoSolicitud2) {
        this.desMotivoSolicitud = desMotivoSolicitud2;
    }

    public void setFecDeLaPeticion(String fecDeLaPeticion2) {
        this.fecDeLaPeticion = fecDeLaPeticion2;
    }

    public void setNombre(String nombre2) {
        this.nombre = nombre2;
    }

    public void setNumExpediente(String numExpediente2) {
        this.numExpediente = numExpediente2;
    }

    public void setReactivarPeticion(String reactivarPeticion2) {
        this.reactivarPeticion = reactivarPeticion2;
    }

    public void setFirma(String firma2) {
        this.firma = firma2;
    }

    public void setFecDeAceptacion(String fecDeAceptacion2) {
        this.fecDeAceptacion = fecDeAceptacion2;
    }

    public void setFecDeBaja(String fecDeBaja2) {
        this.fecDeBaja = fecDeBaja2;
    }

    public void setFecDeDenegacion(String fecDeDenegacion2) {
        this.fecDeDenegacion = fecDeDenegacion2;
    }
}
