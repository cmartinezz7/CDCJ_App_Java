package es.santander.justicia.minisJusticia.models.requests.login;

import es.santander.justicia.BuildConfig;
import org.simpleframework.xml.Element;

public class LoginArg0Detail {
    @Element(name = "coddocum", required = false)
    private String coddocum;
    @Element(name = "jusuario", required = false)
    private String jusuario;
    @Element(name = "password", required = false)
    private String password;
    @Element(name = "tipdoc", required = false)
    private String tipdoc;
    @Element(name = "version", required = false)
    private String version = BuildConfig.VERSION_NAME;

    public LoginArg0Detail(String coddocum2, String jusuario2, String password2, String tipdoc2) {
        this.coddocum = coddocum2;
        this.jusuario = jusuario2;
        this.password = password2;
        this.tipdoc = tipdoc2;
    }
}
