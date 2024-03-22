package es.santander.justicia.minisJusticia.models.requests.authJuzgados;

import es.santander.justicia.minisJusticia.models.requests.DatosPaginacionRequest;
import java.io.Serializable;
import org.simpleframework.xml.Element;

public class AuthJuzgadosArg0Detail implements Serializable {
    @Element(name = "codNumDocumento", required = false)
    private String codNumDocumento;
    @Element(name = "codOrganismo", required = false)
    private String codOrganismo;
    @Element(name = "codTipoDocumento", required = false)
    private String codTipoDocumento;
    @Element(name = "datosPaginacion", required = false)
    private DatosPaginacionRequest datosPaginacionRequest;
    @Element(name = "fechaFinal", required = false)
    private String fechaFinal;
    @Element(name = "fechaInicial", required = false)
    private String fechaInicial;
    @Element(name = "indCaducadas", required = false)
    private String indCaducadas;

    public void setDatosPaginacionRequest(DatosPaginacionRequest datosPaginacionRequest2) {
        this.datosPaginacionRequest = datosPaginacionRequest2;
    }

    public void setCodNumDocumento(String codNumDocumento2) {
        this.codNumDocumento = codNumDocumento2;
    }

    public void setCodOrganismo(String codOrganismo2) {
        this.codOrganismo = codOrganismo2;
    }

    public void setCodTipoDocumento(String codTipoDocumento2) {
        this.codTipoDocumento = codTipoDocumento2;
    }

    public void setFechaFinal(String fechaFinal2) {
        this.fechaFinal = fechaFinal2;
    }

    public void setFechaInicial(String fechaInicial2) {
        this.fechaInicial = fechaInicial2;
    }

    public void setIndCaducadas(String indCaducadas2) {
        this.indCaducadas = indCaducadas2;
    }

    public DatosPaginacionRequest getDatosPaginacionRequest() {
        return this.datosPaginacionRequest;
    }

    public String getCodNumDocumento() {
        return this.codNumDocumento;
    }

    public String getCodOrganismo() {
        return this.codOrganismo;
    }

    public String getCodTipoDocumento() {
        return this.codTipoDocumento;
    }

    public String getFechaFinal() {
        return this.fechaFinal;
    }

    public String getFechaInicial() {
        return this.fechaInicial;
    }

    public String getIndCaducadas() {
        return this.indCaducadas;
    }
}
