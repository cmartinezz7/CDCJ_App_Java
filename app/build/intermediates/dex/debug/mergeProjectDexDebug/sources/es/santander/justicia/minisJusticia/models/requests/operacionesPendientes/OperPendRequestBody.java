package es.santander.justicia.minisJusticia.models.requests.operacionesPendientes;

import org.simpleframework.xml.Element;

public class OperPendRequestBody {
    @Element(name = "wsj:consultaOperacionesPendientes", required = false)
    private OpePendArg0 opePendArg0;

    public OperPendRequestBody(OpePendArg0 opePendArg02) {
        this.opePendArg0 = opePendArg02;
    }
}
