package es.santander.justicia.minisJusticia.models.requests.userDetail;

import org.simpleframework.xml.Element;

public class UserDetailRequestBodyRequest {
    @Element(name = "wsj:detalleUsuario", required = false)
    private String object;

    public String getObject() {
        return this.object;
    }

    public void setObject(String object2) {
        this.object = object2;
    }
}
