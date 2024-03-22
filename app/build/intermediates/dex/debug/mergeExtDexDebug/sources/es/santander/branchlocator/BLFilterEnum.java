package es.santander.branchlocator;

public enum BLFilterEnum {
    WITHDRAW_MONEY(1),
    DEPOSIT_MONEY(2),
    INDIVIDUALS_BRANCH(3),
    SANTANDER_ATM(4),
    WORKCAFE(5),
    OWN_PARKING(6),
    CO_WORKING_SPACES(7),
    WI_FI(8),
    SECURITY_BOX(9),
    DRIVE_THRU(10),
    WHEELCHAIR_ACCESS(11),
    AUDIO_GUIDANCE(12),
    SELECT_BRANCH(13),
    PRIVATE_BANKING_BRANCH(14),
    SME_BRANCH(15),
    POPULAR_BRANCH(16),
    PARTNERS(17),
    OTHER_NON_SANTANDER_ATM(18),
    WITHDRAW_MONEY_WITHOUT_CARD(19),
    WITH_LOW_DENOMINATION_BILL(20),
    CONTACTLESS(21),
    OPEN_EVENINGS(22),
    OPEN_SATURDAYS(23);
    
    private int value;

    private BLFilterEnum(int value2) {
        this.value = value2;
    }

    public int value() {
        return this.value;
    }

    public String valueStr() {
        return this.value + "";
    }
}
