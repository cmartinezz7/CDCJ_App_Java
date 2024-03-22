package es.santander.justicia.minisJusticia.models.responses.cambiarOrganismo;

import es.santander.justicia.minisJusticia.models.responses.GlobalReponseEnvelope;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "soap", reference = "http://schemas.xmlsoap.org/soap/envelope/")})
@Root(name = "soap:Envelope")
public class CambiarOrganismoRespEnvelopment extends GlobalReponseEnvelope {
    @Element(name = "Body", required = false)
    private CambiarOrganismoResponseBody body;

    public CambiarOrganismoResponseBody getBody() {
        return this.body;
    }
}
