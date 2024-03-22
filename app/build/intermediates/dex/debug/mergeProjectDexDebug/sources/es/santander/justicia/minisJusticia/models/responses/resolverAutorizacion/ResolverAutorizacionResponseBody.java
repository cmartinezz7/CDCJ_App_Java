package es.santander.justicia.minisJusticia.models.responses.resolverAutorizacion;

import es.santander.justicia.minisJusticia.models.responses.GlobalResponseReturn;
import org.simpleframework.xml.Element;

public class ResolverAutorizacionResponseBody {
    @Element(name = "resolverAutorizacionResponse", required = false)
    private GlobalResponseReturn globalResponseReturn;

    public GlobalResponseReturn getGlobalResponseReturn() {
        return this.globalResponseReturn;
    }
}
