package es.santander.justicia.minisJusticia.models;

public class Advices {
    public static final String AVS = "AVS";
    public static final String CDI = "CDI";
    public static final String CDM = "CDM";
    public static final String CDO = "CDO";
    public static final String EBE = "EBE";
    public static final String SAO = "SAO";
    private String text;
    private int type;

    public Advices(String text2, int type2) {
        this.text = text2;
        this.type = type2;
    }

    public String getText() {
        return this.text;
    }

    public int getType() {
        return this.type;
    }
}
