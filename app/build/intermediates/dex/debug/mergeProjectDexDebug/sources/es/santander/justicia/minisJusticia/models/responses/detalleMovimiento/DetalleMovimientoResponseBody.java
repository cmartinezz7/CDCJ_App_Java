package es.santander.justicia.minisJusticia.models.responses.detalleMovimiento;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "ns2", reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/")})
@Root(name = "ns2:detalleMovimientoResponse", strict = false)
public class DetalleMovimientoResponseBody extends ErrorResponse {
    @Element(name = "detalleMovimientoResponse", required = false)
    private DetalleMovimientoReturn detalleMovimientoReturn;

    public DetalleMovimientoReturn getDetalleMovimientoReturn() {
        return this.detalleMovimientoReturn;
    }
}
