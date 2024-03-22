package es.santander.justicia.minisJusticia.models.responses.listaMovimientos;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "ns2", reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/")})
@Root(name = "ns2:consultaMovimientosResponse")
public class ListaMovimientoResponseBody extends ErrorResponse {
    @Element(name = "consultaMovimientosResponse", required = false)
    private ListaMovimientosReturn listaMovimientosReturn;

    public ListaMovimientosReturn getListaMovimientosReturn() {
        return this.listaMovimientosReturn;
    }
}
