package es.santander.justicia.minisJusticia.models.responses.anularOpPteIngreso;

import es.santander.justicia.minisJusticia.models.responses.GlobalResponseReturn;
import org.simpleframework.xml.Element;

public class AnularOpPteIngresoResponseBody {
    @Element(name = "anularOpPteIngresoResponse", required = false)
    private GlobalResponseReturn globalResponseReturn;

    public GlobalResponseReturn getGlobalResponseReturn() {
        return this.globalResponseReturn;
    }
}
