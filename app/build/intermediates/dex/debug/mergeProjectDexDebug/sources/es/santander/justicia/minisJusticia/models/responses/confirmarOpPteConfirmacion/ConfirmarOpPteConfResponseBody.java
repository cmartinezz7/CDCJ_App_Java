package es.santander.justicia.minisJusticia.models.responses.confirmarOpPteConfirmacion;

import es.santander.justicia.minisJusticia.models.responses.GlobalResponseReturn;
import org.simpleframework.xml.Element;

public class ConfirmarOpPteConfResponseBody {
    @Element(name = "confirmarOpPteConfirmacionResponse", required = false)
    private GlobalResponseReturn globalResponseReturn;

    public GlobalResponseReturn getGlobalResponseReturn() {
        return this.globalResponseReturn;
    }
}
