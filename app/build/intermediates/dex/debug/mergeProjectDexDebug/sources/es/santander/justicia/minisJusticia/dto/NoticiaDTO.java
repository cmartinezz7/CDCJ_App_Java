package es.santander.justicia.minisJusticia.dto;

public class NoticiaDTO {
    private String asunto;
    private String noticia;
    private String tituloNoticia;

    public String getTituloNoticia() {
        return this.tituloNoticia;
    }

    public void setTituloNoticia(String tituloNoticia2) {
        this.tituloNoticia = tituloNoticia2;
    }

    public String getAsunto() {
        return this.asunto;
    }

    public void setAsunto(String asunto2) {
        this.asunto = asunto2;
    }

    public String getNoticia() {
        return this.noticia;
    }

    public void setNoticia(String noticia2) {
        this.noticia = noticia2;
    }
}
