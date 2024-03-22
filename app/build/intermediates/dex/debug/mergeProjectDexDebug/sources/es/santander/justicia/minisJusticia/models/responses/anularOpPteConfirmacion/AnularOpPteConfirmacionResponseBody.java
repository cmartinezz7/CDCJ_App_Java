package es.santander.justicia.minisJusticia.models.responses.anularOpPteConfirmacion;

import es.santander.justicia.minisJusticia.models.responses.GlobalResponseReturn;
import org.simpleframework.xml.Element;

public class AnularOpPteConfirmacionResponseBody {
    @Element(name = "anularOpPteConfirmacionResponse", required = false)
    private GlobalResponseReturn globalResponseReturn;

    public GlobalResponseReturn getGlobalResponseReturn() {
        return this.globalResponseReturn;
    }
}
