package es.santander.justicia.minisJusticia.models.responses.loginunico;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "soap-env", reference = "http://schemas.xmlsoap.org/soap/envelope/"), @Namespace(prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance")})
@Root(name = "soap-env:Envelope", strict = false)
public class LoginUnicoResponseEnvelope {
    @Element(name = "Body", required = false)
    private LoginUnicoBody loginUnicoBody;

    public LoginUnicoBody getLoginResponseBody() {
        return this.loginUnicoBody;
    }
}
