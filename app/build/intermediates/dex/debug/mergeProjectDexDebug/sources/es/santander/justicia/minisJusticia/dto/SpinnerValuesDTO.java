package es.santander.justicia.minisJusticia.dto;

public class SpinnerValuesDTO {
    private String code;
    private String engValue;
    private String espValue;
    private long id;
    private int position;
    private long spinnerContentId;
    private String valueToShow;

    public long getId() {
        return this.id;
    }

    public void setId(long id2) {
        this.id = id2;
    }

    public long getSpinnerContentId() {
        return this.spinnerContentId;
    }

    public void setSpinnerContentId(long spinnerContentId2) {
        this.spinnerContentId = spinnerContentId2;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position2) {
        this.position = position2;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code2) {
        this.code = code2;
    }

    public String getEspValue() {
        return this.espValue;
    }

    public void setEspValue(String espValue2) {
        this.espValue = espValue2;
    }

    public String getEngValue() {
        return this.engValue;
    }

    public void setEngValue(String engValue2) {
        this.engValue = engValue2;
    }

    public String getValueToShow() {
        return this.valueToShow;
    }

    public void setValueToShow(String valueToShow2) {
        this.valueToShow = valueToShow2;
    }

    public String toString() {
        return this.valueToShow;
    }
}
