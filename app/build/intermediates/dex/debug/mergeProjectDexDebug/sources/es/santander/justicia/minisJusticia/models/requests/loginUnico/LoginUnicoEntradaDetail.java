package es.santander.justicia.minisJusticia.models.requests.loginUnico;

import org.simpleframework.xml.Element;

public class LoginUnicoEntradaDetail {
    @Element(name = "indEstadoUsuario", required = false)
    private String indEstadoUsuario;
    @Element(name = "password", required = false)
    private String password;
    @Element(name = "servicioComerciable", required = false)
    private String servicioComerciable = "AA";
    @Element(name = "usuario", required = false)
    private String usuario;

    public LoginUnicoEntradaDetail(String usuario2, String password2) {
        this.usuario = usuario2;
        this.password = password2;
    }
}
