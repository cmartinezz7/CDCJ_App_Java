package es.santander.justicia.minisJusticia.models.responses.operacionesEjecutadas;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import es.santander.justicia.minisJusticia.models.responses.OperacionesResponseGlobal;
import org.simpleframework.xml.Element;

public class OpeEjectResponseBody extends ErrorResponse {
    @Element(name = "consultaOperacionesUltimos5diasResponse", required = false)
    private OperacionesResponseGlobal operacionesResponseGlobal;

    public OperacionesResponseGlobal getOperacionesResponseGlobal() {
        return this.operacionesResponseGlobal;
    }
}
