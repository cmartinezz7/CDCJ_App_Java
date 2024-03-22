package es.santander.justicia.minisJusticia.models.requests.detalleJuzgado;

import org.simpleframework.xml.Element;

public class DetalleJuzgadoRequestBody {
   @Element(
      name = "wsj:detalleJuzgado",
      required = false
   )
   private DetalleJuzgadoArg0 detalleJuzgadoArg0;

   public DetalleJuzgadoRequestBody(DetalleJuzgadoArg0 detalleJuzgadoArg0) {
      this.detalleJuzgadoArg0 = detalleJuzgadoArg0;
   }
}
