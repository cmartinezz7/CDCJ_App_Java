package es.santander.justicia.minisJusticia.models.requests.operacionesEjecutadas;

import org.simpleframework.xml.Element;

public class OperEjectArg0Detail {
    @Element(name = "codMon")
    private String codMon;
    @Element(name = "coduo")
    private String coduo;
    @Element(name = "rango")
    private int rango;

    public OperEjectArg0Detail(String coduo2, String codMon2, int rango2) {
        this.coduo = coduo2;
        this.codMon = codMon2;
        this.rango = rango2;
    }
}
