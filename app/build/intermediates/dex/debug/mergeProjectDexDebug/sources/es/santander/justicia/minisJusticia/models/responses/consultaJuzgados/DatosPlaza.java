package es.santander.justicia.minisJusticia.models.responses.consultaJuzgados;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DatosPlaza {
    @Element(name = "codplaza", required = false)
    private String codplaza;
    @Element(name = "desplaza", required = false)
    private String desplaza;

    public String getCodplaza() {
        return this.codplaza;
    }

    public String getDesplaza() {
        return this.desplaza;
    }
}
