package es.santander.justicia.minisJusticia.models.requests.buscarExpedientes;

import org.simpleframework.xml.Element;

public class BuscarExpedientesArg0 {
    @Element(name = "arg0", required = false)
    private BuscarExpedientesArg0Detail buscarExpedientesArg0Detail;

    public BuscarExpedientesArg0(BuscarExpedientesArg0Detail buscarExpedientesArg0Detail2) {
        this.buscarExpedientesArg0Detail = buscarExpedientesArg0Detail2;
    }
}
