package es.santander.justicia.minisJusticia.models.requests.cambiarOrganismo;

import org.simpleframework.xml.Element;

public class CambarOrganismoAsigArg0 {
    @Element(name = "arg0", required = false)
    private CambiarOrganismoArg0Detail cambiarOrganismoArg0Detail;

    public void setCambiarOrganismoArg0Detail(CambiarOrganismoArg0Detail cambiarOrganismoArg0Detail2) {
        this.cambiarOrganismoArg0Detail = cambiarOrganismoArg0Detail2;
    }
}
