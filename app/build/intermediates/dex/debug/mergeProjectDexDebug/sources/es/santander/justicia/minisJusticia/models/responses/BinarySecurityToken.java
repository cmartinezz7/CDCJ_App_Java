package es.santander.justicia.minisJusticia.models.responses;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(reference = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd")})
@Root(name = "BinarySecurityToken")
public class BinarySecurityToken {
    @Element(name = "BinarySecurityToken", required = false)
    private String securityToken;

    public String getSecurityToken() {
        return this.securityToken;
    }
}
