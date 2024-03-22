package es.santander.justicia.minisJusticia.models.requests.operativasOperaciones;

import org.simpleframework.xml.Element;

public class AnularOpPteCobroRequestBody {
    @Element(name = "wsj:anularOpPteCobro", required = false)
    private OperGlobalArg0 operGlobalArg0;

    public AnularOpPteCobroRequestBody(OperGlobalArg0 operGlobalArg02) {
        this.operGlobalArg0 = operGlobalArg02;
    }
}
