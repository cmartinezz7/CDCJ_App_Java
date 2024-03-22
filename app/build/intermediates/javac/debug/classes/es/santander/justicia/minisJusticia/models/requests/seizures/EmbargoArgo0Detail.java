package es.santander.justicia.minisJusticia.models.requests.seizures;

import es.santander.justicia.minisJusticia.models.requests.DatosPaginacionRequest;
import org.simpleframework.xml.Element;

public class EmbargoArgo0Detail {
   @Element(
      name = "datosPaginacion",
      required = false
   )
   private DatosPaginacionRequest datosPaginacionRequest;
   @Element(
      name = "juzgadoDestinoExp",
      required = false
   )
   private String juzgadoDestinoExp;
   @Element(
      name = "juzgadoOrigenExp",
      required = false
   )
   private String juzgadoOrigenExp;
   @Element(
      name = "procedimientoExp",
      required = false
   )
   private String procedimientoExp;
   @Element(
      name = "anoAperturaExpediente",
      required = false
   )
   private String anoAperturaExpediente;
   @Element(
      name = "numeroExp",
      required = false
   )
   private String numeroExp;
   @Element(
      name = "importeEmbargadoDesde",
      required = false
   )
   private String importeEmbargadoDesde;
   @Element(
      name = "importeEmbargadoHasta",
      required = false
   )
   private String importeEmbargadoHasta;
   @Element(
      name = "fechaDesde",
      required = false
   )
   private String fechaDesde;
   @Element(
      name = "fechaHasta",
      required = false
   )
   private String fechaHasta;
   @Element(
      name = "codigoTipoEmbargo",
      required = false
   )
   private String codigoTipoEmbargo;
   @Element(
      name = "codigoEstado",
      required = false
   )
   private String codigoEstado;

   public EmbargoArgo0Detail(DatosPaginacionRequest datosPaginacionRequest, String juzgadoDestinoExp, String juzgadoOrigenExp, String procedimientoExp, String anoAperturaExpediente, String numeroExp, String importeEmbargadoDesde, String importeEmbargadoHasta, String fechaDesde, String fechaHasta, String codigoTipoEmbargo, String codigoEstado) {
      this.datosPaginacionRequest = datosPaginacionRequest;
      this.juzgadoDestinoExp = juzgadoDestinoExp;
      if (juzgadoOrigenExp != null) {
         this.juzgadoOrigenExp = juzgadoOrigenExp;
      }

      if (procedimientoExp != null) {
         this.procedimientoExp = procedimientoExp;
      }

      if (anoAperturaExpediente != null) {
         this.anoAperturaExpediente = anoAperturaExpediente;
      }

      if (numeroExp != null) {
         this.numeroExp = numeroExp;
      }

      if (importeEmbargadoDesde != null) {
         this.importeEmbargadoDesde = importeEmbargadoDesde;
      }

      if (importeEmbargadoHasta != null) {
         this.importeEmbargadoHasta = importeEmbargadoHasta;
      }

      if (fechaDesde != null && !fechaDesde.isEmpty()) {
         this.fechaDesde = fechaDesde;
      }

      if (fechaHasta != null && !fechaHasta.isEmpty()) {
         this.fechaHasta = fechaHasta;
      }

      if (codigoTipoEmbargo != null) {
         this.codigoTipoEmbargo = codigoTipoEmbargo;
      }

      if (codigoEstado != null) {
         this.codigoEstado = codigoEstado;
      }

   }
}
