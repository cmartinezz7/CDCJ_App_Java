package es.santander.justicia.minisJusticia.models.requests.detalleAutorizacion;

import org.simpleframework.xml.Element;

public class DetalleAutorizacionUsuario {
    @Element(name = "codNumDocumento")
    private String codNumDocumento;
    @Element(name = "codOrganismo")
    private String codOrganismo;
    @Element(name = "codTipoDocumento")
    private String codTipoDocumento;
    @Element(name = "codUsuario")
    private String codUsuario;
    @Element(name = "fechaFinal")
    private String fechaFinal;
    @Element(name = "fechaInicial")
    private String fechaInicial;

    public String getCodNumDocumento() {
        return this.codNumDocumento;
    }

    public void setCodNumDocumento(String codNumDocumento2) {
        this.codNumDocumento = codNumDocumento2;
    }

    public String getCodOrganismo() {
        return this.codOrganismo;
    }

    public void setCodOrganismo(String codOrganismo2) {
        this.codOrganismo = codOrganismo2;
    }

    public String getCodTipoDocumento() {
        return this.codTipoDocumento;
    }

    public void setCodTipoDocumento(String codTipoDocumento2) {
        this.codTipoDocumento = codTipoDocumento2;
    }

    public String getCodUsuario() {
        return this.codUsuario;
    }

    public void setCodUsuario(String codUsuario2) {
        this.codUsuario = codUsuario2;
    }

    public String getFechaFinal() {
        return this.fechaFinal;
    }

    public void setFechaFinal(String fechaFinal2) {
        this.fechaFinal = fechaFinal2;
    }

    public String getFechaInicial() {
        return this.fechaInicial;
    }

    public void setFechaInicial(String fechaInicial2) {
        this.fechaInicial = fechaInicial2;
    }
}
