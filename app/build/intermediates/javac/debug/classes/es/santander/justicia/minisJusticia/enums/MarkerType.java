package es.santander.justicia.minisJusticia.enums;

public enum MarkerType {
   OFFICE(1, "office"),
   ATM(2, "atm");

   private int id;
   private String name;

   private MarkerType(int id, String name) {
      this.id = id;
      this.name = name;
   }

   public int getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }
}
