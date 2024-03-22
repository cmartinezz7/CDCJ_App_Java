package es.santander.justicia.minisJusticia.models.requests.consultaOperacion;

import es.santander.justicia.minisJusticia.models.requests.DatosPaginacionRequest;
import org.simpleframework.xml.Element;

public class ConsultaOperacionArg0Detail {
   @Element(
      name = "datosPaginacion",
      required = false
   )
   private DatosPaginacionRequest datosPaginacionRequest;
   @Element(
      name = "juzgadoDestino",
      required = false
   )
   private String juzgadoDetino;
   @Element(
      name = "moneda",
      required = false
   )
   private String moneda;
   @Element(
      name = "operacionSeleccionadaMenu",
      required = false
   )
   private String operacionSeleccionadaMenu;
   @Element(
      name = "tipoOperacion",
      required = false
   )
   private String tipoOperacion;
   @Element(
      name = "fechaFin",
      required = false
   )
   private String fechaFin;
   @Element(
      name = "fechaInicio",
      required = false
   )
   private String fechaInicio;

   public ConsultaOperacionArg0Detail(DatosPaginacionRequest datosPaginacionRequest, String juzgadoDetino, String moneda, String tipoOperacion, String operacionSeleccionadaMenu, String fechaFin, String fechaInicio) {
      this.datosPaginacionRequest = datosPaginacionRequest;
      this.juzgadoDetino = juzgadoDetino;
      this.moneda = moneda;
      this.tipoOperacion = tipoOperacion;
      if (operacionSeleccionadaMenu != null) {
         this.operacionSeleccionadaMenu = operacionSeleccionadaMenu;
      }

      this.fechaFin = fechaFin;
      this.fechaInicio = fechaInicio;
   }
}
