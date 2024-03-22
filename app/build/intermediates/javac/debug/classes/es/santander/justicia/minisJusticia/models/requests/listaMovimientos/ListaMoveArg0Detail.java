package es.santander.justicia.minisJusticia.models.requests.listaMovimientos;

import es.santander.justicia.minisJusticia.models.requests.DatosFiltradoRequest;
import es.santander.justicia.minisJusticia.models.requests.DatosPaginacionRequest;
import org.simpleframework.xml.Element;

public class ListaMoveArg0Detail {
   @Element(
      name = "datosOperacion"
   )
   private DatosExpediente datosExpediente;
   @Element(
      name = "datosPaginacion",
      required = false
   )
   private DatosPaginacionRequest datosPaginacionRequest;
   @Element(
      name = "datosFiltrado",
      required = false
   )
   private DatosFiltradoRequest datosFiltrado;

   public ListaMoveArg0Detail(DatosExpediente datosExpediente, DatosPaginacionRequest datosPaginacionRequest, DatosFiltradoRequest datosFiltrado) {
      this.datosExpediente = datosExpediente;
      this.datosPaginacionRequest = datosPaginacionRequest;
      this.datosFiltrado = datosFiltrado;
   }
}
