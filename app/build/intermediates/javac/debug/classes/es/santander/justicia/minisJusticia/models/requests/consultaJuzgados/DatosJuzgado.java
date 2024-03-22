package es.santander.justicia.minisJusticia.models.requests.consultaJuzgados;

import org.simpleframework.xml.Element;

public class DatosJuzgado {
   @Element(
      name = "codprova",
      required = false
   )
   private String codprova;
   @Element(
      name = "codentja",
      required = false
   )
   private String codentja;

   public DatosJuzgado(String codprova, String codentja) {
      this.codprova = codprova;
      this.codentja = codentja;
   }
}
