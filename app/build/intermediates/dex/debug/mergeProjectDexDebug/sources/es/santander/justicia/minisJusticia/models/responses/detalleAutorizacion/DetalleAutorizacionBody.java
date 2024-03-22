package es.santander.justicia.minisJusticia.models.responses.detalleAutorizacion;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "ns2", reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/")})
@Root(name = "ns2:detalleAutorizacionResponse")
public class DetalleAutorizacionBody {
    @Element(name = "detalleAutorizacionResponse", required = false)
    private DetalleAutorizacionReturn detalleAutorizacionReturn;

    public DetalleAutorizacionReturn getDetalleAutorizacionReturn() {
        return this.detalleAutorizacionReturn;
    }
}
