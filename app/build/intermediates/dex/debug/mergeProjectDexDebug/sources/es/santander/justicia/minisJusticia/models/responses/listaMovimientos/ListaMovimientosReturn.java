package es.santander.justicia.minisJusticia.models.responses.listaMovimientos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class ListaMovimientosReturn {
    @Element(name = "return")
    private ListaMovimientosReturnDetail listaMovimientosReturnDetail;

    public ListaMovimientosReturnDetail getListaMovimientosReturnDetail() {
        return this.listaMovimientosReturnDetail;
    }
}
