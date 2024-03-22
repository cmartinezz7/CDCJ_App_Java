package es.santander.justicia.soap.service.login.soap.service.loginDocumento;

import org.ksoap2.serialization.SoapObject;

public class ResponseLoginDocumento {
    private String tokenDocu;

    public ResponseLoginDocumento(SoapObject responseSoapObject) {
        this.tokenDocu = responseSoapObject.getPropertyAsString("tokenCredential");
    }

    public String getTokenDocu() {
        return this.tokenDocu;
    }

    public void setTokenDocu(String token) {
        this.tokenDocu = this.tokenDocu;
    }
}
