package es.santander.justicia.minisJusticia.dto;

public class TimeLineDetailDTO {
   private String statusName;
   private String status;
   private String date;
   private String userName;
   private int order;

   public TimeLineDetailDTO() {
   }

   public TimeLineDetailDTO(String statusName, String status, String date, String userName, int order) {
      this.statusName = statusName;
      this.status = status;
      this.date = date;
      this.userName = userName;
      this.order = order;
   }

   public String getStatusName() {
      return this.statusName;
   }

   public void setStatusName(String statusName) {
      this.statusName = statusName;
   }

   public String getStatus() {
      return this.status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getDate() {
      return this.date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public int getOrder() {
      return this.order;
   }

   public void setOrder(int order) {
      this.order = order;
   }
}
