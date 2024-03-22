package es.santander.justicia.minisJusticia.models.responses.authjuzados;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "ns2", reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/")})
@Root(name = "ns2:buscarAutorizacionesResponse")
public class AutorizacionesUsuarioBody extends ErrorResponse {
    @Element(name = "buscarAutorizacionesResponse", required = false)
    private AutorizacionesUsuarioReturn autorizacionesUsuarioReturn;

    public AutorizacionesUsuarioReturn getAutorizacionesUsuarioReturn() {
        return this.autorizacionesUsuarioReturn;
    }
}
