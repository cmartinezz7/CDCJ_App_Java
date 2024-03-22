package es.santander.justicia.minisJusticia.models.responses.anularOpPteCobro;

import es.santander.justicia.minisJusticia.models.responses.GlobalResponseReturn;
import org.simpleframework.xml.Element;

public class AnularOpPteCobroResponseBody {
    @Element(name = "anularOpPteCobroResponse", required = false)
    private GlobalResponseReturn globalResponseReturn;

    public GlobalResponseReturn getGlobalResponseReturn() {
        return this.globalResponseReturn;
    }
}
