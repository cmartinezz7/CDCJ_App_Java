package es.santander.justicia.minisJusticia.models.responses.avisos;

import es.santander.justicia.minisJusticia.models.responses.GlobalReponseEnvelope;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "soap", reference = "http://schemas.xmlsoap.org/soap/envelope/")})
@Root(name = "soap:Envelope")
public class AvisosResponseEnvelop extends GlobalReponseEnvelope {
    @Element(name = "Body", required = false)
    private AvisosResponseBody body;

    public AvisosResponseBody getBody() {
        return this.body;
    }

    public void setBody(AvisosResponseBody body2) {
        this.body = body2;
    }
}
