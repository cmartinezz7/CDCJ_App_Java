package es.santander.justicia.minisJusticia.dto;

public class SpinnerValuesDTO {
   private long id;
   private long spinnerContentId;
   private int position;
   private String code;
   private String espValue;
   private String engValue;
   private String valueToShow;

   public long getId() {
      return this.id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public long getSpinnerContentId() {
      return this.spinnerContentId;
   }

   public void setSpinnerContentId(long spinnerContentId) {
      this.spinnerContentId = spinnerContentId;
   }

   public int getPosition() {
      return this.position;
   }

   public void setPosition(int position) {
      this.position = position;
   }

   public String getCode() {
      return this.code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getEspValue() {
      return this.espValue;
   }

   public void setEspValue(String espValue) {
      this.espValue = espValue;
   }

   public String getEngValue() {
      return this.engValue;
   }

   public void setEngValue(String engValue) {
      this.engValue = engValue;
   }

   public String getValueToShow() {
      return this.valueToShow;
   }

   public void setValueToShow(String valueToShow) {
      this.valueToShow = valueToShow;
   }

   public String toString() {
      return this.valueToShow;
   }
}
