package es.santander.justicia.minisJusticia.models.responses.operacionesPendientes;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import es.santander.justicia.minisJusticia.models.responses.OperacionesResponseGlobal;
import org.simpleframework.xml.Element;

public class OpePenResponseBody extends ErrorResponse {
    @Element(name = "consultaOperacionesPendientesResponse", required = false)
    private OperacionesResponseGlobal operacionesResponseGlobal;

    public OperacionesResponseGlobal getOperacionesResponseGlobal() {
        return this.operacionesResponseGlobal;
    }
}
