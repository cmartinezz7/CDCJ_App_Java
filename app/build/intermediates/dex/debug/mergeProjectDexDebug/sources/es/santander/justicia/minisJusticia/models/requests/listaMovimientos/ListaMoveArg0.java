package es.santander.justicia.minisJusticia.models.requests.listaMovimientos;

import org.simpleframework.xml.Element;

public class ListaMoveArg0 {
    @Element(name = "arg0")
    private ListaMoveArg0Detail listaMoveArg0Detail;

    public ListaMoveArg0(ListaMoveArg0Detail listaMoveArg0Detail2) {
        this.listaMoveArg0Detail = listaMoveArg0Detail2;
    }
}
