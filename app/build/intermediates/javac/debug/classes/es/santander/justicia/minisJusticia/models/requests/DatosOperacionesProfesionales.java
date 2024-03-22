package es.santander.justicia.minisJusticia.models.requests;

import es.santander.justicia.minisJusticia.models.requests.listaMovimientos.DatosExpediente;
import org.simpleframework.xml.Element;

public class DatosOperacionesProfesionales {
   @Element(
      name = "datosExpediente",
      required = false
   )
   private DatosExpediente datosExpediente;
   @Element(
      name = "codom",
      required = false
   )
   private String codom;
   @Element(
      name = "jtipomod",
      required = false
   )
   private String jtipomod;

   public DatosOperacionesProfesionales(DatosExpediente datosExpediente, String codom, String jtipomod) {
      this.datosExpediente = datosExpediente;
      if (codom != null) {
         this.codom = codom;
      }

      if (jtipomod != null) {
         this.jtipomod = jtipomod;
      }

   }
}
