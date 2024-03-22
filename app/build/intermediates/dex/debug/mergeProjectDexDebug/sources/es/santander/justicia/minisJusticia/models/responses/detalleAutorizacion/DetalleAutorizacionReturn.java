package es.santander.justicia.minisJusticia.models.responses.detalleAutorizacion;

import org.simpleframework.xml.Element;

public class DetalleAutorizacionReturn {
    @Element(name = "return", required = false)
    private DetalleAutorizacion detalleAutorizacion;

    public DetalleAutorizacion getDetalleAutorizacion() {
        return this.detalleAutorizacion;
    }
}
