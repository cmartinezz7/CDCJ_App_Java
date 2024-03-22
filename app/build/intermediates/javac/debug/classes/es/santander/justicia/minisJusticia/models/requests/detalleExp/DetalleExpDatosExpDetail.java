package es.santander.justicia.minisJusticia.models.requests.detalleExp;

import org.simpleframework.xml.Element;

public class DetalleExpDatosExpDetail {
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

   public DetalleExpDatosExpDetail(String janoapex, String jnumexp, String jproced, String juzga, String juzgori) {
      this.janoapex = janoapex;
      this.jnumexp = jnumexp;
      this.jproced = jproced;
      this.juzga = juzga;
      this.juzgori = juzgori;
   }
}
