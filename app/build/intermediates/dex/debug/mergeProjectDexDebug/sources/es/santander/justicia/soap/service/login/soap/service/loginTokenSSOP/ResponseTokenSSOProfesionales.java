package es.santander.justicia.soap.service.login.soap.service.loginTokenSSOP;

import org.ksoap2.serialization.SoapObject;

public class ResponseTokenSSOProfesionales {
    private String tokenSSO;

    public ResponseTokenSSOProfesionales(SoapObject responseSoapObject) {
        this.tokenSSO = responseSoapObject.getPropertyAsString("tokenSSO");
    }

    public String getTokenSSO() {
        return this.tokenSSO;
    }

    public void setTokenSSO(String token) {
        this.tokenSSO = this.tokenSSO;
    }
}
