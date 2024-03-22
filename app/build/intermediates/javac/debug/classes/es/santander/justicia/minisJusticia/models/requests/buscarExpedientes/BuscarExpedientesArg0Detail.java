package es.santander.justicia.minisJusticia.models.requests.buscarExpedientes;

import es.santander.justicia.minisJusticia.models.requests.DatosFiltradoRequest;
import es.santander.justicia.minisJusticia.models.requests.DatosPaginacionRequest;
import org.simpleframework.xml.Element;

public class BuscarExpedientesArg0Detail {
   @Element(
      name = "datosAcceso",
      required = false
   )
   private DatosAcceso datosAcceso;
   @Element(
      name = "datosFiltrado",
      required = false
   )
   private DatosFiltradoRequest datosFiltradoRequest;
   @Element(
      name = "datosPaginacion",
      required = false
   )
   private DatosPaginacionRequest datosPaginacionRequest;

   public BuscarExpedientesArg0Detail(DatosAcceso datosAcceso, DatosFiltradoRequest datosFiltradoRequest, DatosPaginacionRequest datosPaginacionRequest) {
      this.datosAcceso = datosAcceso;
      this.datosFiltradoRequest = datosFiltradoRequest;
      this.datosPaginacionRequest = datosPaginacionRequest;
   }
}
