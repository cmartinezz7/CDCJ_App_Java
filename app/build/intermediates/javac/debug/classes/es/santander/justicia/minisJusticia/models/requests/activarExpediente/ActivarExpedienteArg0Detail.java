package es.santander.justicia.minisJusticia.models.requests.activarExpediente;

import org.simpleframework.xml.Element;

public class ActivarExpedienteArg0Detail {
   @Element(
      name = "anoAperturaExpediente",
      required = false
   )
   private String anoAperturaExpediente;
   @Element(
      name = "numeroExpediente",
      required = false
   )
   private String numeroExpediente;
   @Element(
      name = "codigoJuzgadoDestino",
      required = false
   )
   private String codigoJuzgadoDestino;
   @Element(
      name = "codigoJuzgadoOrigen",
      required = false
   )
   private String codigoJuzgadoOrigen;
   @Element(
      name = "codigoProcedimiento",
      required = false
   )
   private String codigoProcedimiento;
   @Element(
      name = "codigoExpediente",
      required = false
   )
   private String codigoExpediente;
   @Element(
      name = "codigoMoneda",
      required = false
   )
   private String codigoMoneda;
   @Element(
      name = "firma",
      required = false
   )
   private String firma;

   public ActivarExpedienteArg0Detail(String anoAperturaExpediente, String numeroExpediente, String codigoJuzgadoDestino, String codigoJuzgadoOrigen, String codigoProcedimiento, String codigoExpediente, String codigoMoneda, String firma) {
      this.anoAperturaExpediente = anoAperturaExpediente;
      this.numeroExpediente = numeroExpediente;
      this.codigoJuzgadoDestino = codigoJuzgadoDestino;
      this.codigoJuzgadoOrigen = codigoJuzgadoOrigen;
      this.codigoProcedimiento = codigoProcedimiento;
      this.codigoExpediente = codigoExpediente;
      this.codigoMoneda = codigoMoneda;
      this.firma = firma;
   }
}
