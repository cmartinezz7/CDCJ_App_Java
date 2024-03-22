package es.santander.justicia.minisJusticia.models.responses.detalleExpediente;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "ns2", reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/")})
@Root(name = "ns2:detalleExpedienteResponse")
public class DetalleExpResponseBody extends ErrorResponse {
    @Element(name = "detalleExpedienteResponse", required = false)
    private DetalleExpReturn detalleMovimientoReturn;

    public DetalleExpReturn getDetalleMovimientoReturn() {
        return this.detalleMovimientoReturn;
    }
}
