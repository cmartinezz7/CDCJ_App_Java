package es.santander.justicia.minisJusticia.models.responses.aceptarSolicitud;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import es.santander.justicia.minisJusticia.models.responses.GlobalResponseReturn;
import org.simpleframework.xml.Element;

public class AceptarSolicitudResponseBody extends ErrorResponse {
    @Element(name = "aceptarSolicitudProfesionalResponse", required = false)
    private GlobalResponseReturn globalResponseReturn;

    public GlobalResponseReturn getGlobalResponseReturn() {
        return this.globalResponseReturn;
    }
}
