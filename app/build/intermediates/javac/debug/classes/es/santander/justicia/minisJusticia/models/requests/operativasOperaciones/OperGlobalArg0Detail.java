package es.santander.justicia.minisJusticia.models.requests.operativasOperaciones;

import org.simpleframework.xml.Element;

public class OperGlobalArg0Detail {
   @Element(
      name = "datosOperacion",
      required = false
   )
   private OperDatosOperacion datosOperacion;
   @Element(
      name = "firma",
      required = false
   )
   private String firma;
   @Element(
      name = "motivoAnulacion",
      required = false
   )
   private String motivoAnulacion;

   public OperGlobalArg0Detail(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
      this.datosOperacion = datosOperacion;
      this.firma = firma;
      this.motivoAnulacion = motivoAnulacion;
   }
}
