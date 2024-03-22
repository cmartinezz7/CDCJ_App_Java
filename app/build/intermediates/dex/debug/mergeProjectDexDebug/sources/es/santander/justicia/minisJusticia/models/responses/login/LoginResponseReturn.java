package es.santander.justicia.minisJusticia.models.responses.login;

import org.simpleframework.xml.Element;

public class LoginResponseReturn {
    @Element(name = "return", required = false)
    private Login login;

    public Login getLogin() {
        return this.login;
    }
}
