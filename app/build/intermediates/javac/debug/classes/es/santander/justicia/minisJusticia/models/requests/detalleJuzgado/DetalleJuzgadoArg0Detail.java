package es.santander.justicia.minisJusticia.models.requests.detalleJuzgado;

import org.simpleframework.xml.Element;

public class DetalleJuzgadoArg0Detail {
   @Element(
      name = "datosJuzgado"
   )
   private DatosJuzgado datosJuzgado;

   public DetalleJuzgadoArg0Detail(DatosJuzgado datosJuzgado) {
      this.datosJuzgado = datosJuzgado;
   }
}
