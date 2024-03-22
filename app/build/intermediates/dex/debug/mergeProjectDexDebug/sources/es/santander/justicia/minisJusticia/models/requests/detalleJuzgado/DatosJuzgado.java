package es.santander.justicia.minisJusticia.models.requests.detalleJuzgado;

import org.simpleframework.xml.Element;

public class DatosJuzgado {
    @Element(name = "juzga")
    private String juzga;

    public DatosJuzgado(String juzga2) {
        this.juzga = juzga2;
    }
}
