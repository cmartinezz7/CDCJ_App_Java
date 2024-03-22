package es.santander.justicia.minisJusticia.models.requests.advices;

import org.simpleframework.xml.Element;

public class AdvicesRequestBodyRequest {
    @Element(name = "wsj:consultaAvisos", required = false)
    private AdvicesArg0 advicesArg0;

    public AdvicesArg0 getAdvicesArg0() {
        return this.advicesArg0;
    }

    public void setAdvicesArg0(AdvicesArg0 advicesArg02) {
        this.advicesArg0 = advicesArg02;
    }
}
