package es.santander.justicia.minisJusticia.models.requests.operativasOperaciones;

import org.simpleframework.xml.Element;

public class ConfirmarOpPteConfiRequestBody {
    @Element(name = "wsj:confirmarOpPteConfirmacion", required = false)
    private OperGlobalArg0 operGlobalArg0;

    public ConfirmarOpPteConfiRequestBody(OperGlobalArg0 operGlobalArg02) {
        this.operGlobalArg0 = operGlobalArg02;
    }
}
