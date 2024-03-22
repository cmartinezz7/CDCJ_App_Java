package es.santander.justicia.minisJusticia.enums;

public enum MovementStatusEnum {
   EXECUTED("Ejecutado"),
   PENDING("Pendiente"),
   EXPIRED("Caducado");

   private String name;

   private MovementStatusEnum(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }
}
