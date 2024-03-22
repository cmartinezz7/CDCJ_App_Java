package es.santander.justicia.minisJusticia.models.responses;

import java.io.Serializable;
import org.simpleframework.xml.Element;

public class DatosPaginacionResponse implements Serializable {
   @Element(
      name = "numeroPagina",
      required = false
   )
   private int numerPagina;
   @Element(
      name = "tamannoPagina",
      required = false
   )
   private int tamannoPagina;
   @Element(
      name = "totalPaginas",
      required = false
   )
   private int totalPaginas;

   public int getNumerPagina() {
      return this.numerPagina;
   }

   public int getTamannoPagina() {
      return this.tamannoPagina;
   }

   public int getTotalPaginas() {
      return this.totalPaginas;
   }
}
