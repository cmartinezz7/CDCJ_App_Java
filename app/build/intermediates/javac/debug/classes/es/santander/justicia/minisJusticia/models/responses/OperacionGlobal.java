package es.santander.justicia.minisJusticia.models.responses;

import org.simpleframework.xml.Element;

public class OperacionGlobal {
   @Element(
      name = "codmon"
   )
   private String codmon;
   @Element(
      name = "importe"
   )
   private String importe;
   @Element(
      name = "tipoOpe"
   )
   private String tipoOpe;
   @Element(
      name = "totalOperaciones"
   )
   private String totalOperaciones;

   public String getCodmon() {
      return this.codmon;
   }

   public String getImporte() {
      return this.importe;
   }

   public String getTipoOpe() {
      return this.tipoOpe;
   }

   public String getTotalOperaciones() {
      return this.totalOperaciones;
   }
}
