package es.santander.justicia.minisJusticia.models;

public class Tribunal {
    private String charge;
    private String endDate;
    private String initDate;
    private String organismo;
    private String relactionType;
    private String tribunalName;
    private String user;

    public Tribunal(String tribunalName2, String relactionType2, String charge2, String initDate2, String endDate2, String organismo2, String user2) {
        this.tribunalName = tribunalName2;
        this.relactionType = relactionType2;
        this.charge = charge2;
        this.initDate = initDate2;
        this.endDate = endDate2;
        this.organismo = organismo2;
        this.user = user2;
    }

    public String getTribunalName() {
        return this.tribunalName;
    }

    public String getRelactionType() {
        return this.relactionType;
    }

    public String getCharge() {
        return this.charge;
    }

    public String getInitDate() {
        return this.initDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getOrganismo() {
        return this.organismo;
    }

    public String getUser() {
        return this.user;
    }
}
