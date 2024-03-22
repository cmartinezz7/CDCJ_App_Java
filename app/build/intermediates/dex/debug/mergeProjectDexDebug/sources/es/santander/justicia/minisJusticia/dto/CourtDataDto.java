package es.santander.justicia.minisJusticia.dto;

public class CourtDataDto {
    private String courtCode;
    private String judicialEnvironment;
    private String organismName;
    private String phoneNumber;
    private String province;
    private String status;

    public String getOrganismName() {
        return this.organismName;
    }

    public void setOrganismName(String organismName2) {
        this.organismName = organismName2;
    }

    public String getJudicialEnvironment() {
        return this.judicialEnvironment;
    }

    public void setJudicialEnvironment(String judicialEnvironment2) {
        this.judicialEnvironment = judicialEnvironment2;
    }

    public String getCourtCode() {
        return this.courtCode;
    }

    public void setCourtCode(String courtCode2) {
        this.courtCode = courtCode2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province2) {
        this.province = province2;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber2) {
        this.phoneNumber = phoneNumber2;
    }
}
