package es.santander.justicia.minisJusticia.models.responses.detalleJuzgado;

import es.santander.justicia.minisJusticia.models.responses.consultaJuzgados.ConsultaJuzgadoReturn;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "ns2", reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/")})
@Root(name = "ns2:detalleJuzgadoResponse")
public class DetalleJuzgadoResponseBody {
    @Element(name = "detalleJuzgadoResponse", required = false)
    private ConsultaJuzgadoReturn consultaJuzgadoReturn;

    public ConsultaJuzgadoReturn getConsultaJuzgadoReturn() {
        return this.consultaJuzgadoReturn;
    }
}
