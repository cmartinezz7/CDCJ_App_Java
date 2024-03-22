package es.santander.justicia.minisJusticia.models.responses.buscPetAcceso;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "ns2", reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/")})
@Root(name = "ns2:buscarPeticionesAccesoResponse")
public class BuscPetAccResponseBody extends ErrorResponse {
    @Element(name = "buscarPeticionesAccesoResponse", required = false)
    private BuscPetAccResponseReturn buscPetAccResponseReturn;

    public BuscPetAccResponseReturn getBuscPetAccResponseReturn() {
        return this.buscPetAccResponseReturn;
    }
}
