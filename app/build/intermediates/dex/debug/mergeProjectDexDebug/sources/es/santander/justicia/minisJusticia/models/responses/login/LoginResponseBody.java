package es.santander.justicia.minisJusticia.models.responses.login;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import org.simpleframework.xml.Element;

public class LoginResponseBody extends ErrorResponse {
    @Element(name = "loginJuzgadosMobileResponse", required = false)
    private LoginResponseReturn loginResponseReturn;

    public LoginResponseReturn getLoginResponseReturn() {
        return this.loginResponseReturn;
    }
}
