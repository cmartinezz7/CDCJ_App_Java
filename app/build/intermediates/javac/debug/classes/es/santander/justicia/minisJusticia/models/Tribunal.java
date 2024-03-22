package es.santander.justicia.minisJusticia.models;

public class Tribunal {
   private String tribunalName;
   private String relactionType;
   private String charge;
   private String initDate;
   private String endDate;
   private String organismo;
   private String user;

   public Tribunal(String tribunalName, String relactionType, String charge, String initDate, String endDate, String organismo, String user) {
      this.tribunalName = tribunalName;
      this.relactionType = relactionType;
      this.charge = charge;
      this.initDate = initDate;
      this.endDate = endDate;
      this.organismo = organismo;
      this.user = user;
   }

   public String getTribunalName() {
      return this.tribunalName;
   }

   public String getRelactionType() {
      return this.relactionType;
   }

   public String getCharge() {
      return this.charge;
   }

   public String getInitDate() {
      return this.initDate;
   }

   public String getEndDate() {
      return this.endDate;
   }

   public String getOrganismo() {
      return this.organismo;
   }

   public String getUser() {
      return this.user;
   }
}
