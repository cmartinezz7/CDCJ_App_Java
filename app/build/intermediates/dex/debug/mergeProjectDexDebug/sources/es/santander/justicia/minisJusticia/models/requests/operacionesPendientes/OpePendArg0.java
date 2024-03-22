package es.santander.justicia.minisJusticia.models.requests.operacionesPendientes;

import org.simpleframework.xml.Element;

public class OpePendArg0 {
    @Element(name = "arg0", required = false)
    private OpePendArg0Detail opePendArg0Detail;

    public OpePendArg0(OpePendArg0Detail opePendArg0Detail2) {
        this.opePendArg0Detail = opePendArg0Detail2;
    }
}
