package es.santander.justicia.minisJusticia.enums;

public enum PopupTypeEnum {
    EMPTY(0),
    ACCESS_REQUEST_SENT_CORRECTLY(1);
    
    private int popupId;

    private PopupTypeEnum(int popupId2) {
        this.popupId = popupId2;
    }

    public int getId() {
        return this.popupId;
    }

    public static PopupTypeEnum getPopupType(int popupId2) {
        if (popupId2 != 1) {
            return null;
        }
        return ACCESS_REQUEST_SENT_CORRECTLY;
    }
}
