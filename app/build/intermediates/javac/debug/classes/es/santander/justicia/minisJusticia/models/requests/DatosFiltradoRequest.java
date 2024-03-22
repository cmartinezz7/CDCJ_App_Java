package es.santander.justicia.minisJusticia.models.requests;

import org.simpleframework.xml.Element;

public class DatosFiltradoRequest {
   @Element(
      name = "jfechareDe",
      required = false
   )
   private String jfechareDe;
   @Element(
      name = "jfechareHasta",
      required = false
   )
   private String jfechareHasta;
   @Element(
      name = "jimpnomiDe",
      required = false
   )
   private String jimpnomiDe;
   @Element(
      name = "jimpnomiHasta",
      required = false
   )
   private String jimpnomiHasta;
   @Element(
      name = "tipsel",
      required = false
   )
   private String tipsel;

   public DatosFiltradoRequest(String jfechareDe, String jfechareHasta, String jimpnomiDe, String jimpnomiHasta, String tipsel) {
      if (jfechareDe != null) {
         this.jfechareDe = jfechareDe;
      }

      if (jfechareHasta != null) {
         this.jfechareHasta = jfechareHasta;
      }

      if (jimpnomiDe != null) {
         this.jimpnomiDe = jimpnomiDe;
      }

      if (jimpnomiHasta != null) {
         this.jimpnomiHasta = jimpnomiHasta;
      }

      if (tipsel != null) {
         this.tipsel = tipsel;
      }

   }
}
