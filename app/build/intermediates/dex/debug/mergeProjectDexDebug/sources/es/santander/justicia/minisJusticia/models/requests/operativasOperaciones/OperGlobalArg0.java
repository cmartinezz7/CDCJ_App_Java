package es.santander.justicia.minisJusticia.models.requests.operativasOperaciones;

import org.simpleframework.xml.Element;

public class OperGlobalArg0 {
    @Element(name = "arg0", required = false)
    private OperGlobalArg0Detail operGlobalArg0Detail;

    public OperGlobalArg0(OperGlobalArg0Detail operGlobalArg0Detail2) {
        this.operGlobalArg0Detail = operGlobalArg0Detail2;
    }
}
