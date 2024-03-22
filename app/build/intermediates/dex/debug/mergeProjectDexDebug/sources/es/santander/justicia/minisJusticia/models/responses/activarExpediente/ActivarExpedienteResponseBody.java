package es.santander.justicia.minisJusticia.models.responses.activarExpediente;

import es.santander.justicia.minisJusticia.models.responses.GlobalResponseReturn;
import org.simpleframework.xml.Element;

public class ActivarExpedienteResponseBody {
    @Element(name = "activarExpedienteResponse", required = false)
    private GlobalResponseReturn globalResponseReturn;

    public GlobalResponseReturn getGlobalResponseReturn() {
        return this.globalResponseReturn;
    }
}
