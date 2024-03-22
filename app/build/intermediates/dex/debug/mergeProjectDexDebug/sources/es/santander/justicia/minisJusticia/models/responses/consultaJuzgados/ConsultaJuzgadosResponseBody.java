package es.santander.justicia.minisJusticia.models.responses.consultaJuzgados;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "ns2", reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/")})
@Root(name = "ns2:consultaJuzgadosResponse")
public class ConsultaJuzgadosResponseBody extends ErrorResponse {
    @Element(name = "consultaJuzgadosResponse", required = false)
    private ConsultaJuzgadoReturn consultaJuzgadoReturn;

    public ConsultaJuzgadoReturn getConsultaJuzgadoReturn() {
        return this.consultaJuzgadoReturn;
    }
}
