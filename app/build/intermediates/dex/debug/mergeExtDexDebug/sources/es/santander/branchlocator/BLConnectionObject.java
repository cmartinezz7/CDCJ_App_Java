package es.santander.branchlocator;

public class BLConnectionObject {
    private boolean enabled;
    private boolean status;
    private String type;

    public BLConnectionObject(String type2, boolean enabled2, boolean status2) {
        this.type = type2;
        this.enabled = enabled2;
        this.status = status2;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type2) {
        this.type = type2;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled2) {
        this.enabled = enabled2;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status2) {
        this.status = status2;
    }
}
