package es.santander.justicia.minisJusticia.models.responses.detallePetAcceRespose;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "ns2", reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/")})
@Root(name = "ns2:detallePeticionAccesoResponse")
public class DetallePetAccResponseBody {
    @Element(name = "detallePeticionAccesoResponse", required = false)
    private DetallePetAccesReturn detallePetAccesReturn;

    public DetallePetAccesReturn getDetallePetAccesReturn() {
        return this.detallePetAccesReturn;
    }
}
