package es.santander.justicia.minisJusticia.models.responses.loginunico;

import es.santander.justicia.minisJusticia.models.responses.BinarySecurityToken;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class LogoUnicoHeader {
    @Element(name = "Header", required = false)
    private BinarySecurityToken binarySecurityToken;
}
