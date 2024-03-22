package es.santander.justicia.minisJusticia.models.responses.operacionesPendientes;

import es.santander.justicia.minisJusticia.models.responses.GlobalReponseEnvelope;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "soap", reference = "http://schemas.xmlsoap.org/soap/envelope/")})
@Root(name = "soap:Envelope")
public class OpePenResponseEnvelop extends GlobalReponseEnvelope {
    @Element(name = "Body", required = false)
    private OpePenResponseBody body;

    public OpePenResponseBody getBody() {
        return this.body;
    }
}
