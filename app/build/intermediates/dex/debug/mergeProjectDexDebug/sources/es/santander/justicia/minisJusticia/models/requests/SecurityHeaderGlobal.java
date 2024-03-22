package es.santander.justicia.minisJusticia.models.requests;

import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.connections.RetrofitUtility;
import org.simpleframework.xml.Element;

public class SecurityHeaderGlobal {
    @Element(name = "wsse:Security", required = false)
    private SecurityHeader securityHeader = new SecurityHeader();

    public SecurityHeaderGlobal() {
        String token = RetrofitUtility.updateToken;
        this.securityHeader.setSecurityToken(token == null ? MainApplication.getAppContext().getUser().getToken() : token);
    }
}
