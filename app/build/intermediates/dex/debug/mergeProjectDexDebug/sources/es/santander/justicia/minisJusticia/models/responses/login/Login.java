package es.santander.justicia.minisJusticia.models.responses.login;

import org.simpleframework.xml.Element;

public class Login {
    @Element(name = "tokenSSO")
    private String tokenSSO;

    public String getTokenSSO() {
        return this.tokenSSO;
    }
}
