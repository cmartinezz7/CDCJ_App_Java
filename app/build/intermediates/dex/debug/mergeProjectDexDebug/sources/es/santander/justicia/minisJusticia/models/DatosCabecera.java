package es.santander.justicia.minisJusticia.models;

import org.simpleframework.xml.Element;

public class DatosCabecera {
    @Element(name = "idioma", required = false)
    private Idioma idioma = new Idioma();
}
