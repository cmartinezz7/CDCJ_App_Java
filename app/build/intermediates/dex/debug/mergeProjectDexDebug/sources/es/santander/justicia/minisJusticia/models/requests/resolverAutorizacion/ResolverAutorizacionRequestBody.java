package es.santander.justicia.minisJusticia.models.requests.resolverAutorizacion;

import org.simpleframework.xml.Element;

public class ResolverAutorizacionRequestBody {
    @Element(name = "wsj:resolverAutorizacion", required = false)
    private ResolverAutorizacionArg0 resolverAutorizacionArg0;

    public ResolverAutorizacionRequestBody(ResolverAutorizacionArg0 resolverAutorizacionArg02) {
        this.resolverAutorizacionArg0 = resolverAutorizacionArg02;
    }
}
