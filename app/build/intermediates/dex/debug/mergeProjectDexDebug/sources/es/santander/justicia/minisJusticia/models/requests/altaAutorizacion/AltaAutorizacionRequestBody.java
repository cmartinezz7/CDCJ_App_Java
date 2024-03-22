package es.santander.justicia.minisJusticia.models.requests.altaAutorizacion;

import org.simpleframework.xml.Element;

public class AltaAutorizacionRequestBody {
    @Element(name = "wsj:altaAutorizacion", required = false)
    private AltaAutorizacionArg0 altaAutorizacionArg0;

    public AltaAutorizacionRequestBody(AltaAutorizacionArg0 altaAutorizacionArg02) {
        this.altaAutorizacionArg0 = altaAutorizacionArg02;
    }
}
