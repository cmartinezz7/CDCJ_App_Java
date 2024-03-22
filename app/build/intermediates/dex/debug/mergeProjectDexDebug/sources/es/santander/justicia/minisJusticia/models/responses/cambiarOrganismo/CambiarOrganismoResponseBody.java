package es.santander.justicia.minisJusticia.models.responses.cambiarOrganismo;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import org.simpleframework.xml.Element;

public class CambiarOrganismoResponseBody extends ErrorResponse {
    @Element(name = "cambiarOrganismoResponse", required = false)
    private CambiarOrganismoResponseReturn selectTribunalResponeReturn;

    public CambiarOrganismoResponseReturn getSelectTribunalResponeReturn() {
        return this.selectTribunalResponeReturn;
    }
}
