package es.santander.justicia.minisJusticia.models.responses.anularOpPteIngreso;

import es.santander.justicia.minisJusticia.models.responses.GlobalReponseEnvelope;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "soap", reference = "http://schemas.xmlsoap.org/soap/envelope/")})
@Root(name = "soap:Envelope")
public class AnularOpPteIngresoResponseEnvelope extends GlobalReponseEnvelope {
    @Element(name = "Body", required = false)
    private AnularOpPteIngresoResponseBody anularOpPteIngresoResponseBody;

    public AnularOpPteIngresoResponseBody getBody() {
        return this.anularOpPteIngresoResponseBody;
    }
}
