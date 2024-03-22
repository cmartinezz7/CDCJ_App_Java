package es.santander.justicia.minisJusticia.dto;

public class CourtDataDto {
   private String organismName;
   private String judicialEnvironment;
   private String courtCode;
   private String status;
   private String province;
   private String phoneNumber;

   public String getOrganismName() {
      return this.organismName;
   }

   public void setOrganismName(String organismName) {
      this.organismName = organismName;
   }

   public String getJudicialEnvironment() {
      return this.judicialEnvironment;
   }

   public void setJudicialEnvironment(String judicialEnvironment) {
      this.judicialEnvironment = judicialEnvironment;
   }

   public String getCourtCode() {
      return this.courtCode;
   }

   public void setCourtCode(String courtCode) {
      this.courtCode = courtCode;
   }

   public String getStatus() {
      return this.status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getProvince() {
      return this.province;
   }

   public void setProvince(String province) {
      this.province = province;
   }

   public String getPhoneNumber() {
      return this.phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }
}
