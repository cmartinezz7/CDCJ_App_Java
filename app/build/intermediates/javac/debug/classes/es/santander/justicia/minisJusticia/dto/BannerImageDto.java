package es.santander.justicia.minisJusticia.dto;

public class BannerImageDto {
   private String id;
   private String location;
   private String imageUrl;
   private String actionUrl;

   public String getId() {
      return this.id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getLocation() {
      return this.location;
   }

   public void setLocation(String location) {
      this.location = location;
   }

   public String getImageUrl() {
      return this.imageUrl;
   }

   public void setImageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
   }

   public String getActionUrl() {
      return this.actionUrl;
   }

   public void setActionUrl(String actionUrl) {
      this.actionUrl = actionUrl;
   }
}
