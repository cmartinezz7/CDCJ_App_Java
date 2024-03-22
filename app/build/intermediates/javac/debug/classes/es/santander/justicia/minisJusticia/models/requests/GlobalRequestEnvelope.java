package es.santander.justicia.minisJusticia.models.requests;

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
   reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/"
)})
public class GlobalRequestEnvelope extends HeaderSecurity {
   @Element(
      name = "soapenv:Body",
      required = false
   )
   private Object body;
   private HeaderSecurity headerSecurity;

   public Object getBody() {
      return this.body;
   }

   public void setBody(Object body) {
      this.headerSecurity = new HeaderSecurity();
      this.body = body;
   }
}
