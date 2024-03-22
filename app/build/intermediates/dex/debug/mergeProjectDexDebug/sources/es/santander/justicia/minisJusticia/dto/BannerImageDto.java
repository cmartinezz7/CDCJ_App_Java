package es.santander.justicia.minisJusticia.dto;

public class BannerImageDto {
    private String actionUrl;
    private String id;
    private String imageUrl;
    private String location;

    public String getId() {
        return this.id;
    }

    public void setId(String id2) {
        this.id = id2;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location2) {
        this.location = location2;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl2) {
        this.imageUrl = imageUrl2;
    }

    public String getActionUrl() {
        return this.actionUrl;
    }

    public void setActionUrl(String actionUrl2) {
        this.actionUrl = actionUrl2;
    }
}
