package es.santander.justicia.minisJusticia.models.responses.denegarSolicitud;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import es.santander.justicia.minisJusticia.models.responses.GlobalResponseReturn;
import org.simpleframework.xml.Element;

public class DenegarSolicitudResponseBody extends ErrorResponse {
    @Element(name = "denegarSolicitudProfesionalResponse", required = false)
    private GlobalResponseReturn globalResponseReturn;

    public GlobalResponseReturn getGlobalResponseReturn() {
        return this.globalResponseReturn;
    }
}
