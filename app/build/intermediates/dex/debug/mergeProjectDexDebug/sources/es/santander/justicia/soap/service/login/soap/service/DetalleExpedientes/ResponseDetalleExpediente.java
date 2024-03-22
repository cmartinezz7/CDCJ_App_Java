package es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes;

import org.ksoap2.serialization.SoapObject;

public class ResponseDetalleExpediente {
    private SoapObject datosExpediente;

    public ResponseDetalleExpediente(SoapObject responseSoapObject) {
        this.datosExpediente = (SoapObject) responseSoapObject.getProperty("datosExpediente");
    }

    public SoapObject getDatosExpediente() {
        return this.datosExpediente;
    }
}
