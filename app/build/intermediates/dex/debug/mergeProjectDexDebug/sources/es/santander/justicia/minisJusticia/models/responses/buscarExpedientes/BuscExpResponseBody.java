package es.santander.justicia.minisJusticia.models.responses.buscarExpedientes;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "ns2", reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/")})
@Root(name = "ns2:buscarExpedientesResponse")
public class BuscExpResponseBody extends ErrorResponse {
    @Element(name = "buscarExpedientesResponse", required = false)
    private BuscExpResponseReturn buscExpResponseReturn;

    public BuscExpResponseReturn getBuscExpResponseReturn() {
        return this.buscExpResponseReturn;
    }
}
