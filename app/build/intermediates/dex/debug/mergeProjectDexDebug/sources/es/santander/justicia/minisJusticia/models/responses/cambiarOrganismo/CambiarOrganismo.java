package es.santander.justicia.minisJusticia.models.responses.cambiarOrganismo;

import org.simpleframework.xml.Element;

public class CambiarOrganismo {
    @Element(name = "codigoResult")
    private String codigoResult;
    @Element(name = "descResult")
    private String descResult;

    public String getCodigoResult() {
        return this.codigoResult;
    }

    public String getDescResult() {
        return this.descResult;
    }
}
