package es.santander.justicia.minisJusticia.models;

import org.simpleframework.xml.Element;

public class Idioma {
   @Element(
      name = "IDIOMA_ISO",
      required = false
   )
   private String idiomaIso = "es";
   @Element(
      name = "DIALECTO_ISO",
      required = false
   )
   private String dialectoIso = "ES";
}
