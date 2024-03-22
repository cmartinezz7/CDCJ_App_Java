package es.santander.justicia.minisJusticia.models.requests;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "soapenv", reference = "http://schemas.xmlsoap.org/soap/envelope/"), @Namespace(prefix = "wsj", reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/")})
@Root(name = "soapenv:Envelope")
public class GlobalRequestProfessionalEnvelope {
    @Element(name = "soapenv:Body", required = false)
    private Object body;
    private String headerSecurity;

    public Object getBody() {
        return this.body;
    }

    public void setBody(Object body2) {
        this.headerSecurity = "";
        this.body = body2;
    }
}
