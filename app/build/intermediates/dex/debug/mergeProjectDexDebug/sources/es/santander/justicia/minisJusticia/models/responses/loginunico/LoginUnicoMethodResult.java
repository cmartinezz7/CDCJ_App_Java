package es.santander.justicia.minisJusticia.models.responses.loginunico;

import org.simpleframework.xml.Element;

public class LoginUnicoMethodResult {
    @Element(name = "methodResult", required = false)
    private LoginUnicoMethodResultDetail methodResult;

    public LoginUnicoMethodResultDetail getMethodResultDetail() {
        return this.methodResult;
    }
}
