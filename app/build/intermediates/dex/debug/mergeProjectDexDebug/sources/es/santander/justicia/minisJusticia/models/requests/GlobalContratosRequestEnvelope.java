package es.santander.justicia.minisJusticia.models.requests;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "soapenv", reference = "http://schemas.xmlsoap.org/soap/envelope/"), @Namespace(prefix = "v1", reference = "http://www.isban.es/webservices/MOEMC2/Contratos_la/F_moemc2_contratos_la/empresas/ACEMPMOVContratos/v1")})
@Root(name = "soapenv:Envelope")
public class GlobalContratosRequestEnvelope {
    @Element(name = "soapenv:Body", required = false)
    private Object body;
    @Element(name = "soapenv:Header", required = false)
    private String header = "";

    public Object getBody() {
        return this.body;
    }

    public void setBody(Object body2) {
        this.body = body2;
    }
}
