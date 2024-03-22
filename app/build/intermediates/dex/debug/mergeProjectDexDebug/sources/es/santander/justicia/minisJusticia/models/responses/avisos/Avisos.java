package es.santander.justicia.minisJusticia.models.responses.avisos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "avisos")
public class Avisos {
    @Element(name = "codAviso")
    private String codAviso;
    @Element(name = "codOperacion", required = false)
    private String codOperacion;
    @Element(name = "codOrganismo", required = false)
    private String codOrganismo;
    @Element(name = "desAviso")
    private String desAviso;

    public String getCodAviso() {
        return this.codAviso;
    }

    public String getDesAviso() {
        return this.desAviso;
    }

    public String getCodOperacion() {
        return this.codOperacion;
    }

    public String getCodOrganismo() {
        return this.codOrganismo;
    }
}
