package es.santander.branchlocator;

public class POIListItem {
    String distance;
    String id;
    String subtitle;
    String title;

    public POIListItem() {
    }

    public POIListItem(String id2, String title2, String subtitle2, String distance2) {
        this.id = id2;
        this.title = title2;
        this.subtitle = subtitle2;
        this.distance = distance2;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id2) {
        this.id = id2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String subtitle2) {
        this.subtitle = subtitle2;
    }

    public String getDistance() {
        return this.distance;
    }

    public void setDistance(String distance2) {
        this.distance = distance2;
    }

    public String getSubtitleFormat() {
        return BLUtils.capitalizeAllString(this.subtitle);
    }
}
