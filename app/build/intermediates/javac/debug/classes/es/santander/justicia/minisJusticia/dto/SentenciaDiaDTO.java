package es.santander.justicia.minisJusticia.dto;

public class SentenciaDiaDTO {
   private String tituloSentencia;
   private String link;
   private String description;
   private String guid;
   private String pubDate;
   private String pubDateZone;

   public String getTituloSentencia() {
      return this.tituloSentencia;
   }

   public void setTituloSentencia(String tituloSentencia) {
      this.tituloSentencia = tituloSentencia;
   }

   public String getLink() {
      return this.link;
   }

   public void setLink(String link) {
      this.link = link;
   }

   public String getDescription() {
      return this.description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getGuid() {
      return this.guid;
   }

   public void setGuid(String guid) {
      this.guid = guid;
   }

   public String getPubDate() {
      return this.pubDate;
   }

   public void setPubDate(String pubDate) {
      this.pubDate = pubDate;
   }

   public String getPubDateZone() {
      return this.pubDateZone;
   }

   public void setPubDateZone(String pubDateZone) {
      this.pubDateZone = pubDateZone;
   }
}
