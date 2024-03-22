package es.santander.justicia.minisJusticia.models.requests.consultaJuzgados;

import org.simpleframework.xml.Element;

public class DatosJuzgado {
    @Element(name = "codentja", required = false)
    private String codentja;
    @Element(name = "codprova", required = false)
    private String codprova;

    public DatosJuzgado(String codprova2, String codentja2) {
        this.codprova = codprova2;
        this.codentja = codentja2;
    }
}
