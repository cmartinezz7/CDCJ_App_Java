package es.santander.justicia.minisJusticia.models.responses.modificarSolicitud;

import es.santander.justicia.minisJusticia.models.responses.GlobalResponseReturn;
import org.simpleframework.xml.Element;

public class ModificarSolicitudResponseBody {
    @Element(name = "modificarSolicitudProfesionalResponse", required = false)
    private GlobalResponseReturn globalResponseReturn;

    public GlobalResponseReturn getGlobalResponseReturn() {
        return this.globalResponseReturn;
    }
}
