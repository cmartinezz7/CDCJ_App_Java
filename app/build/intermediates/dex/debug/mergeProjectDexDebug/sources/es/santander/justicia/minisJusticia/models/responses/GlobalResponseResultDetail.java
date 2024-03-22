package es.santander.justicia.minisJusticia.models.responses;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class GlobalResponseResultDetail {
    @Element(name = "codigoResult", required = false)
    private String codigoResult;
    @Element(name = "descResult", required = false)
    private String descResult;

    public String getCodigoResult() {
        return this.codigoResult;
    }

    public String getDescResult() {
        return this.descResult;
    }
}
