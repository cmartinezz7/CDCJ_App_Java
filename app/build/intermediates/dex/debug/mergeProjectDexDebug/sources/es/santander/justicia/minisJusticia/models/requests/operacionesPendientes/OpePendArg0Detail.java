package es.santander.justicia.minisJusticia.models.requests.operacionesPendientes;

import org.simpleframework.xml.Element;

public class OpePendArg0Detail {
    @Element(name = "codUo")
    private String coduo;

    public OpePendArg0Detail(String coduo2) {
        this.coduo = coduo2;
    }
}
