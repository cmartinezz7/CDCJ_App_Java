package es.santander.justicia.minisJusticia.models.responses.bajaSolicitud;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import es.santander.justicia.minisJusticia.models.responses.GlobalResponseReturn;
import org.simpleframework.xml.Element;

public class BajaSolicitudResponseBody extends ErrorResponse {
    @Element(name = "bajaSolicitudProfesionalResponse", required = false)
    private GlobalResponseReturn globalResponseReturn;

    public GlobalResponseReturn getGlobalResponseReturn() {
        return this.globalResponseReturn;
    }
}
