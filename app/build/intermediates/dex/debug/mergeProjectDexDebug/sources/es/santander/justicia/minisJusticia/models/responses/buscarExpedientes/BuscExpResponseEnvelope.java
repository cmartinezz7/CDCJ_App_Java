package es.santander.justicia.minisJusticia.models.responses.buscarExpedientes;

import es.santander.justicia.minisJusticia.models.responses.GlobalReponseEnvelope;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "soap", reference = "http://schemas.xmlsoap.org/soap/envelope/")})
@Root(name = "soap:Envelope")
public class BuscExpResponseEnvelope extends GlobalReponseEnvelope {
    @Element(name = "Body", required = false)
    private BuscExpResponseBody body;

    public BuscExpResponseBody getBody() {
        return this.body;
    }
}
