package es.santander.justicia.minisJusticia.enums;

public enum MarkerType {
    OFFICE(1, "office"),
    ATM(2, "atm");
    
    private int id;
    private String name;

    private MarkerType(int id2, String name2) {
        this.id = id2;
        this.name = name2;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
