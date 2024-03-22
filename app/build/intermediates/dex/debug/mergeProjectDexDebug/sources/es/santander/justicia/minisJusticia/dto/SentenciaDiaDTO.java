package es.santander.justicia.minisJusticia.dto;

public class SentenciaDiaDTO {
    private String description;
    private String guid;
    private String link;
    private String pubDate;
    private String pubDateZone;
    private String tituloSentencia;

    public String getTituloSentencia() {
        return this.tituloSentencia;
    }

    public void setTituloSentencia(String tituloSentencia2) {
        this.tituloSentencia = tituloSentencia2;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link2) {
        this.link = link2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public String getGuid() {
        return this.guid;
    }

    public void setGuid(String guid2) {
        this.guid = guid2;
    }

    public String getPubDate() {
        return this.pubDate;
    }

    public void setPubDate(String pubDate2) {
        this.pubDate = pubDate2;
    }

    public String getPubDateZone() {
        return this.pubDateZone;
    }

    public void setPubDateZone(String pubDateZone2) {
        this.pubDateZone = pubDateZone2;
    }
}
