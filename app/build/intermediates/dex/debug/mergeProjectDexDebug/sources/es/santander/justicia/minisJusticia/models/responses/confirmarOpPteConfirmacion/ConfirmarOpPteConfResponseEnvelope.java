package es.santander.justicia.minisJusticia.models.responses.confirmarOpPteConfirmacion;

import es.santander.justicia.minisJusticia.models.responses.GlobalReponseEnvelope;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "soap", reference = "http://schemas.xmlsoap.org/soap/envelope/")})
@Root(name = "soap:Envelope")
public class ConfirmarOpPteConfResponseEnvelope extends GlobalReponseEnvelope {
    @Element(name = "Body", required = false)
    private ConfirmarOpPteConfResponseBody confirmarOpPteConfResponseBody;

    public ConfirmarOpPteConfResponseBody getBody() {
        return this.confirmarOpPteConfResponseBody;
    }
}
