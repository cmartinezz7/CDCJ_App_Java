package es.santander.justicia.minisJusticia.models.requests.consultaJuzgados;

import es.santander.justicia.minisJusticia.models.requests.DatosPaginacionRequest;
import org.simpleframework.xml.Element;

public class ConsultaJuzgadosArg0Detail {
   @Element(
      name = "datosJuzgado",
      required = false
   )
   private DatosJuzgado datosJuzgado;
   @Element(
      name = "datosPaginacion",
      required = false
   )
   private DatosPaginacionRequest datosPaginacionRequest;

   public ConsultaJuzgadosArg0Detail(DatosJuzgado datosJuzgado, DatosPaginacionRequest datosPaginacionRequest) {
      this.datosJuzgado = datosJuzgado;
      this.datosPaginacionRequest = datosPaginacionRequest;
   }
}
