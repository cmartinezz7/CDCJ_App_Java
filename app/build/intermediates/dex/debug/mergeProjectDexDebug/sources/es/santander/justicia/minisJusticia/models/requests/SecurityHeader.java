package es.santander.justicia.minisJusticia.models.requests;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "wsse", reference = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd")})
@Root(name = "wsse:Security")
public class SecurityHeader {
    @Element(name = "BinarySecurityToken", required = false)
    private String securityToken;

    public String getSecurityToken() {
        return this.securityToken;
    }

    public void setSecurityToken(String city) {
        this.securityToken = city;
    }
}
