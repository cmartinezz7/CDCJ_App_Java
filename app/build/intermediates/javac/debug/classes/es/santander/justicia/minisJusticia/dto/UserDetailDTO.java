package es.santander.justicia.minisJusticia.dto;

public class UserDetailDTO {
   private String groupID;
   private String name;
   private String surname;
   private String surname2;

   public String getGroupID() {
      return this.groupID;
   }

   public void setGroupID(String groupID) {
      this.groupID = groupID;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getSurname() {
      return this.surname;
   }

   public void setSurname(String surname) {
      this.surname = surname;
   }

   public String getSurname2() {
      return this.surname2;
   }

   public void setSurname2(String surname2) {
      this.surname2 = surname2;
   }
}
