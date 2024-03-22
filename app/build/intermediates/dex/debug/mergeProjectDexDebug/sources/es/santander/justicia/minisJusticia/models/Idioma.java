package es.santander.justicia.minisJusticia.models;

import org.simpleframework.xml.Element;

public class Idioma {
    @Element(name = "DIALECTO_ISO", required = false)
    private String dialectoIso = "ES";
    @Element(name = "IDIOMA_ISO", required = false)
    private String idiomaIso = "es";
}
