package es.santander.justicia.minisJusticia.models.responses.seizures;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "ns2", reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/")})
@Root(name = "ns2:buscarEmbargosResponse", strict = false)
public class EmbargoResponseBody {
    @Element(name = "buscarEmbargosResponse", required = false)
    private EmbargoReturn embargoReturn;

    public EmbargoReturn getEmbargoReturn() {
        return this.embargoReturn;
    }
}
