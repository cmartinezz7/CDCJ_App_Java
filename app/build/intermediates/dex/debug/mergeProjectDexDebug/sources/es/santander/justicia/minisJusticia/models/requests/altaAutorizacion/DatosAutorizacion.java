package es.santander.justicia.minisJusticia.models.requests.altaAutorizacion;

import org.simpleframework.xml.Element;

public class DatosAutorizacion {
    @Element(name = "codNumDocumento", required = false)
    private String codNumDocumento;
    @Element(name = "codOrganismo", required = false)
    private String codOrganismo;
    @Element(name = "codTipoDocumento", required = false)
    private String codTipoDocumento;
    @Element(name = "fechaFinal", required = false)
    private String fechaFinal;
    @Element(name = "fechaInicial", required = false)
    private String fechaInicial;

    public DatosAutorizacion(String codNumDocumento2, String codOrganismo2, String fechaInicial2, String fechaFinal2, String docType) {
        this.codNumDocumento = codNumDocumento2;
        this.codOrganismo = codOrganismo2;
        this.codTipoDocumento = docType;
        this.fechaInicial = fechaInicial2;
        this.fechaFinal = fechaFinal2;
    }
}
