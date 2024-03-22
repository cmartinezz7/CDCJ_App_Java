package es.santander.justicia.minisJusticia.models.requests.login;

import org.simpleframework.xml.Element;

public class LoginBodyRequestBody {
    @Element(name = "wsj:loginJuzgadosMobile", required = false)
    private LoginArg0 loginArg0;

    public void setLoginArg0(LoginArg0 loginArg02) {
        this.loginArg0 = loginArg02;
    }
}
