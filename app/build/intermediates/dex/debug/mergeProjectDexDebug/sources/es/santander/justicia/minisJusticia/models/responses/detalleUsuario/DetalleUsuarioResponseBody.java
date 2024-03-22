package es.santander.justicia.minisJusticia.models.responses.detalleUsuario;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "ns2", reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/")})
@Root(name = "ns2:detalleUsuarioResponse")
public class DetalleUsuarioResponseBody extends ErrorResponse {
    @Element(name = "detalleUsuarioResponse", required = false)
    private DetalleUsuarioResponeReturn detalleUsuarioResponseReturn;

    public DetalleUsuarioResponeReturn getDetalleUsuarioResponseReturn() {
        return this.detalleUsuarioResponseReturn;
    }
}
