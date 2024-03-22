package es.santander.branchlocator;

/* compiled from: BLSchedule */
enum BLDays {
    MONDAY(R.string.bl_monday),
    TUESDAY(R.string.bl_tuesday),
    WEDNESDAY(R.string.bl_wednesday),
    THURSDAY(R.string.bl_thursday),
    FRIDAY(R.string.bl_friday),
    SATURDAY(R.string.bl_saturday),
    SUNDAY(R.string.bl_sunday);
    
    private final int value;

    private BLDays(int value2) {
        this.value = value2;
    }

    public int getValue() {
        return this.value;
    }
}
