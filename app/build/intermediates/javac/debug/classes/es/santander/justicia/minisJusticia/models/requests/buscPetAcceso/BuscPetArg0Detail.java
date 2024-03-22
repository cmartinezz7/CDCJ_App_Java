package es.santander.justicia.minisJusticia.models.requests.buscPetAcceso;

import es.santander.justicia.minisJusticia.models.requests.DatosPaginacionRequest;
import org.simpleframework.xml.Element;

public class BuscPetArg0Detail {
   @Element(
      name = "datosPaginacion",
      required = false
   )
   private DatosPaginacionRequest datosPaginacionRequest;
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
      name = "codEstadoPeticion",
      required = false
   )
   private String codEstadoPeticion;

   public void setDatosPaginacionRequest(DatosPaginacionRequest datosPaginacionRequest) {
      this.datosPaginacionRequest = datosPaginacionRequest;
   }

   public void setJuzga(String juzga) {
      this.juzga = juzga;
   }

   public void setJuzgori(String juzgori) {
      this.juzgori = juzgori;
   }

   public void setJproced(String jproced) {
      this.jproced = jproced;
   }

   public void setJnumexp(String jnumexp) {
      this.jnumexp = jnumexp;
   }

   public void setJanoapex(String janoapex) {
      this.janoapex = janoapex;
   }

   public void setCodEstadoPeticion(String codEstadoPeticion) {
      this.codEstadoPeticion = codEstadoPeticion;
   }
}
