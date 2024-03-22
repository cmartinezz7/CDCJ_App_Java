package es.santander.justicia.minisJusticia.models.requests.resolverAutorizacion;

import org.simpleframework.xml.Element;

public class ResolverAutorizacionArg0Detail {
    @Element(name = "autorizacionRetrocesion", required = false)
    private AutorizacionRetrocesionDto autorizacionRetrocesion;
    @Element(name = "firma", required = false)
    private String firma;

    public ResolverAutorizacionArg0Detail(AutorizacionRetrocesionDto autorizacionRetrocesion2, String firma2) {
        this.autorizacionRetrocesion = autorizacionRetrocesion2;
        this.firma = firma2;
    }
}
