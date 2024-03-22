package es.santander.justicia.minisJusticia.enums;

public enum PopupTypeEnum {
   EMPTY(0),
   ACCESS_REQUEST_SENT_CORRECTLY(1);

   private int popupId;

   private PopupTypeEnum(int popupId) {
      this.popupId = popupId;
   }

   public int getId() {
      return this.popupId;
   }

   public static PopupTypeEnum getPopupType(int popupId) {
      PopupTypeEnum popupType = null;
      switch(popupId) {
      case 1:
         popupType = ACCESS_REQUEST_SENT_CORRECTLY;
      default:
         return popupType;
      }
   }
}
