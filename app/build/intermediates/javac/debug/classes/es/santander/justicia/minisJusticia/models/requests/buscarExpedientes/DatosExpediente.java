package es.santander.justicia.minisJusticia.models.requests.buscarExpedientes;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(
   strict = false
)
public class DatosExpediente {
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
      name = "jproced",
      required = false
   )
   private String jproced;
   @Element(
      name = "jnumexp",
      required = false
   )
   private String jnumexp;
   @Element(
      name = "janoapex",
      required = false
   )
   private String janoapex;
   @Element(
      name = "codmon",
      required = false
   )
   private String codmon;
   @Element(
      name = "sitexp",
      required = false
   )
   private String sitexp;

   public DatosExpediente(String juzga, String juzgori, String jproced, String jnumexp, String janoapex, String codmon, String sitexp) {
      if (juzga != null) {
         this.juzga = juzga;
      }

      if (juzgori != null) {
         this.juzgori = juzgori;
      }

      if (jproced != null) {
         this.jproced = jproced;
      }

      if (jnumexp != null) {
         this.jnumexp = jnumexp;
      }

      if (janoapex != null) {
         this.janoapex = janoapex;
      }

      if (codmon != null) {
         this.codmon = codmon;
      }

      if (sitexp != null) {
         this.sitexp = sitexp;
      }

   }
}
