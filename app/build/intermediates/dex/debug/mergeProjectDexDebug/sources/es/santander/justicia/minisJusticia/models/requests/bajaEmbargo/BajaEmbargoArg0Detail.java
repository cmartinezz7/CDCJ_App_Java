package es.santander.justicia.minisJusticia.models.requests.bajaEmbargo;

import org.simpleframework.xml.Element;

public class BajaEmbargoArg0Detail {
    @Element(name = "codigoUnidadOrganizativa", required = false)
    private String codigoUnidadOrganizativa;
    @Element(name = "firma", required = false)
    private String firma;
    @Element(name = "numeroEmbargo", required = false)
    private String numeroEmbargo;
    @Element(name = "observaciones", required = false)
    private String observaciones;

    public BajaEmbargoArg0Detail(String codigoUnidadOrganizativa2, String numeroEmbargo2, String firma2, String observaciones2) {
        this.codigoUnidadOrganizativa = codigoUnidadOrganizativa2;
        this.numeroEmbargo = numeroEmbargo2;
        this.firma = firma2;
        if (observaciones2 != null) {
            this.observaciones = observaciones2;
        }
    }
}
