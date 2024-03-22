package es.santander.justicia.minisJusticia.models.responses.consultaOperaciones;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "ns2", reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/")})
@Root(name = "ns2:consultaOperacionesResponse")
public class ConsuOperResponseBody extends ErrorResponse {
    @Element(name = "consultaOperacionesResponse", required = false)
    private ConsuOperResponseReturn consuOperResponseReturn;

    public ConsuOperResponseReturn getConsuOperResponseReturn() {
        return this.consuOperResponseReturn;
    }
}
