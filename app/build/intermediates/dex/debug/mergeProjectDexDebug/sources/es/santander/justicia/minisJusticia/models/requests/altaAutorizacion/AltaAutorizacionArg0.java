package es.santander.justicia.minisJusticia.models.requests.altaAutorizacion;

import org.simpleframework.xml.Element;

public class AltaAutorizacionArg0 {
    @Element(name = "arg0", required = false)
    private AltaAutorizationArg0Detail altaAutorizationArg0Detail;

    public AltaAutorizacionArg0(AltaAutorizationArg0Detail altaAutorizationArg0Detail2) {
        this.altaAutorizationArg0Detail = altaAutorizationArg0Detail2;
    }
}
