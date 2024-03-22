package es.santander.justicia.minisJusticia.models.requests;

import java.io.Serializable;
import org.simpleframework.xml.Element;

public class DatosPaginacionRequest implements Serializable {
   @Element(
      name = "numeroPagina"
   )
   private int numerPagina;
   @Element(
      name = "tamannoPagina"
   )
   private int tamannoPagina;

   public void setNumerPagina(int numerPagina) {
      this.numerPagina = numerPagina;
   }

   public void setTamannoPagina(int tamannoPagina) {
      this.tamannoPagina = tamannoPagina;
   }

   public DatosPaginacionRequest(int numerPagina, int tamannoPagina) {
      this.numerPagina = numerPagina;
      this.tamannoPagina = tamannoPagina;
   }
}
