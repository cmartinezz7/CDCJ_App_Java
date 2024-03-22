package es.santander.justicia.minisJusticia.models.responses.cambiarOrganismo;

import org.simpleframework.xml.Element;

public class CambiarOrganismoResponseReturn {
    @Element(name = "return")
    private CambiarOrganismo cambiarOrganismo;

    public CambiarOrganismo getCambiarOrganismo() {
        return this.cambiarOrganismo;
    }
}
