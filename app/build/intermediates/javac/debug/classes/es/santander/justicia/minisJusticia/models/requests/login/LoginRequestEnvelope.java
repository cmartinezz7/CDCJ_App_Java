package es.santander.justicia.minisJusticia.models.requests.login;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@Root(
   name = "soapenv:Envelope"
)
@NamespaceList({@Namespace(
   prefix = "soapenv",
   reference = "http://schemas.xmlsoap.org/soap/envelope/"
), @Namespace(
   prefix = "wsj",
   reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobileLogin/"
)})
public class LoginRequestEnvelope {
   @Element(
      name = "soapenv:Body",
      required = false
   )
   private Object body;

   public Object getBody() {
      return this.body;
   }

   public void setBody(Object body) {
      this.body = body;
   }
}
