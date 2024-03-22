package es.santander.justicia.minisJusticia.models.requests.operacionesEjecutadas;

import org.simpleframework.xml.Element;

public class OperEjectRequestBody {
    @Element(name = "wsj:consultaOperacionesUltimos5dias", required = false)
    private OperEjectArg0 operEjectArg0;

    public OperEjectRequestBody(OperEjectArg0 operEjectArg02) {
        this.operEjectArg0 = operEjectArg02;
    }
}
