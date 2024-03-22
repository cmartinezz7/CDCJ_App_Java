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
   prefix = "v1",
   reference = "http://www.isban.es/webservices/MOEMC2/Contratos_la/F_moemc2_contratos_la/empresas/ACEMPMOVContratos/v1"
)})
public class GlobalContratosRequestEnvelope {
   @Element(
      name = "soapenv:Header",
      required = false
   )
   private String header = "";
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
