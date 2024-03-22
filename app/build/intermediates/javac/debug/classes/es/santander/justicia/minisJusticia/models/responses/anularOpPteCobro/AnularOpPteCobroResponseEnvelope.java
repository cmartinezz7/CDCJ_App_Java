package es.santander.justicia.minisJusticia.models.responses.anularOpPteCobro;

import es.santander.justicia.minisJusticia.models.responses.GlobalReponseEnvelope;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@Root(
   name = "soap:Envelope"
)
@NamespaceList({@Namespace(
   prefix = "soap",
   reference = "http://schemas.xmlsoap.org/soap/envelope/"
)})
public class AnularOpPteCobroResponseEnvelope extends GlobalReponseEnvelope {
   @Element(
      name = "Body",
      required = false
   )
   private AnularOpPteCobroResponseBody anularOpPteCobroResponseBody;

   public AnularOpPteCobroResponseBody getBody() {
      return this.anularOpPteCobroResponseBody;
   }
}
