package es.santander.justicia.soap.service.login.soap.service.buscarExpedientes;

import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.SoapObject;

public class ResponseBuscarExpediente {
    private List<SoapObject> listaDatosExpediente = new ArrayList();

    public ResponseBuscarExpediente(SoapObject responseSoapObject) {
        for (int i = 0; i < responseSoapObject.getPropertyCount() - 1; i++) {
            this.listaDatosExpediente.add((SoapObject) responseSoapObject.getProperty(i));
        }
    }

    public List<SoapObject> getListaDatosExpediente() {
        return this.listaDatosExpediente;
    }
}
