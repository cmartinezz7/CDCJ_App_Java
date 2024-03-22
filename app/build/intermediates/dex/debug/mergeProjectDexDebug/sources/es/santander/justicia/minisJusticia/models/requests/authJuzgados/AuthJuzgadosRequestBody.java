package es.santander.justicia.minisJusticia.models.requests.authJuzgados;

import org.simpleframework.xml.Element;

public class AuthJuzgadosRequestBody {
    @Element(name = "wsj:buscarAutorizaciones", required = false)
    private AuthJuzgadosArg0 authJuzgadosArg0;

    public void setAuthJuzgadosArg0(AuthJuzgadosArg0 authJuzgadosArg02) {
        this.authJuzgadosArg0 = authJuzgadosArg02;
    }
}
