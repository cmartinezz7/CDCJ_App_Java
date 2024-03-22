package es.santander.justicia.minisJusticia.dto;

public class NoticiaDTO {
   private String tituloNoticia;
   private String asunto;
   private String noticia;

   public String getTituloNoticia() {
      return this.tituloNoticia;
   }

   public void setTituloNoticia(String tituloNoticia) {
      this.tituloNoticia = tituloNoticia;
   }

   public String getAsunto() {
      return this.asunto;
   }

   public void setAsunto(String asunto) {
      this.asunto = asunto;
   }

   public String getNoticia() {
      return this.noticia;
   }

   public void setNoticia(String noticia) {
      this.noticia = noticia;
   }
}
