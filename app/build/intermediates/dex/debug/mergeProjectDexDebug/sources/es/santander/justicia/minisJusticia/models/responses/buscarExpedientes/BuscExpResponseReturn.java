package es.santander.justicia.minisJusticia.models.responses.buscarExpedientes;

import es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew;
import java.util.ArrayList;
import org.simpleframework.xml.ElementList;

public class BuscExpResponseReturn {
    @ElementList(name = "return")
    private ArrayList<DatosExpedienteNew> datosExpedienteResponses;

    public ArrayList<DatosExpedienteNew> getDatosExpedienteResponses() {
        return this.datosExpedienteResponses;
    }
}
