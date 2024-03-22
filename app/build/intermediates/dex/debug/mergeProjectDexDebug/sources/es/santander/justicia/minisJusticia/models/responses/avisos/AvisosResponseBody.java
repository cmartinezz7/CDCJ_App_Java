package es.santander.justicia.minisJusticia.models.responses.avisos;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "ns2", reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/")})
@Root(name = "ns2:consultaAvisosResponse")
public class AvisosResponseBody extends ErrorResponse {
    @Element(name = "consultaAvisosResponse", required = false)
    private AvisosResponseReturn avisosReturnResponse;

    public AvisosResponseReturn getAvisosReturnResponse() {
        return this.avisosReturnResponse;
    }
}
