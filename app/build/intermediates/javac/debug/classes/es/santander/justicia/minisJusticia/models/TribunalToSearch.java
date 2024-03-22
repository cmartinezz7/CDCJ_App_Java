package es.santander.justicia.minisJusticia.models;

public class TribunalToSearch {
   private String environment;
   private String state;
   private String province;

   public TribunalToSearch(String environment, String state, String province) {
      this.environment = environment;
      this.state = state;
      this.province = province;
   }

   public String getEnvironment() {
      return this.environment;
   }

   public String getState() {
      return this.state;
   }

   public String getProvince() {
      return this.province;
   }
}
