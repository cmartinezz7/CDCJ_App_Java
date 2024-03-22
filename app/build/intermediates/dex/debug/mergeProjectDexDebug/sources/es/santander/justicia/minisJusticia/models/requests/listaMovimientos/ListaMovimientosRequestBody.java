package es.santander.justicia.minisJusticia.models.requests.listaMovimientos;

import org.simpleframework.xml.Element;

public class ListaMovimientosRequestBody {
    @Element(name = "wsj:consultaMovimientos", required = false)
    private ListaMoveArg0 listaMoveArg0;

    public ListaMovimientosRequestBody(ListaMoveArg0 listaMoveArg02) {
        this.listaMoveArg0 = listaMoveArg02;
    }
}
