package es.santander.justicia.minisJusticia.models.responses;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class GlobalReponseEnvelope {
    @Element(name = "Header", required = false)
    private BinarySecurityToken binarySecurityToken;

    public BinarySecurityToken getBinarySecurityToken() {
        return this.binarySecurityToken;
    }
}
