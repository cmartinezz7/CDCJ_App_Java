package es.santander.justicia.minisJusticia.models.requests.login;

import org.simpleframework.xml.Element;

public class LogoutRequestBodyRequest {
    @Element(name = "wsj:logoutJuzgadosMobile", required = false)
    private String object;

    public String getObject() {
        return this.object;
    }

    public void setObject(String object2) {
        this.object = object2;
    }
}
