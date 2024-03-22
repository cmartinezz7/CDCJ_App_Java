package es.santander.justicia.minisJusticia.models.responses.bajaEmbargo;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import es.santander.justicia.minisJusticia.models.responses.GlobalResponseReturn;
import org.simpleframework.xml.Element;

public class BajaEmbargoResponseBody extends ErrorResponse {
    @Element(name = "bajaEmbargoResponse", required = false)
    private GlobalResponseReturn globalResponseReturn;

    public GlobalResponseReturn getGlobalResponseReturn() {
        return this.globalResponseReturn;
    }
}
