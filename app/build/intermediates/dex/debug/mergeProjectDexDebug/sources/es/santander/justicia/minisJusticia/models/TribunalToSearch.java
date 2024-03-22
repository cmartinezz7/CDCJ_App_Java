package es.santander.justicia.minisJusticia.models;

public class TribunalToSearch {
    private String environment;
    private String province;
    private String state;

    public TribunalToSearch(String environment2, String state2, String province2) {
        this.environment = environment2;
        this.state = state2;
        this.province = province2;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public String getState() {
        return this.state;
    }

    public String getProvince() {
        return this.province;
    }
}
