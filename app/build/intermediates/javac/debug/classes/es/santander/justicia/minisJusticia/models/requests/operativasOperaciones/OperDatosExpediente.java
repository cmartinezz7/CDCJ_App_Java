package es.santander.justicia.minisJusticia.models.requests.operativasOperaciones;

import org.simpleframework.xml.Element;

public class OperDatosExpediente {
   @Element(
      name = "codExpediente",
      required = false
   )
   private String codExpediente;
   @Element(
      name = "janoapex",
      required = false
   )
   private String janoapex;
   @Element(
      name = "jnumexp",
      required = false
   )
   private String jnumexp;
   @Element(
      name = "jproced",
      required = false
   )
   private String jproced;
   @Element(
      name = "juzga",
      required = false
   )
   private String juzga;
   @Element(
      name = "juzgori",
      required = false
   )
   private String juzgori;
   @Element(
      name = "saldos",
      required = false
   )
   private String saldos;

   public OperDatosExpediente(String codExpediente, String janoapex, String jnumexp, String jproced, String juzga, String juzgori) {
      this.codExpediente = codExpediente;
      this.janoapex = janoapex;
      this.jnumexp = jnumexp;
      this.jproced = jproced;
      this.juzga = juzga;
      this.juzgori = juzgori;
      this.saldos = "";
   }
}
