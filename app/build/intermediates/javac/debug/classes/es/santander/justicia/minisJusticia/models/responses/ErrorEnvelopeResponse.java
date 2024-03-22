package es.santander.justicia.minisJusticia.models.responses;

import es.santander.justicia.minisJusticia.models.responses.erroLoginUnico.ErrorLoginUnicoBody;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@Root(
   name = "soap-env:Envelope",
   strict = false
)
@NamespaceList({@Namespace(
   prefix = "soap-env",
   reference = "http://schemas.xmlsoap.org/soap/envelope/"
), @Namespace(
   prefix = "xsi",
   reference = "http://www.w3.org/2001/XMLSchema-instance"
)})
public class ErrorEnvelopeResponse {
   @Element(
      name = "Body",
      required = false
   )
   private ErrorLoginUnicoBody body;

   public ErrorLoginUnicoBody getBody() {
      return this.body;
   }
}
