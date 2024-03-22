package es.santander.justicia.minisJusticia.models.responses.detalleExpediente;

import org.simpleframework.xml.Element;

public class DetalleExpReturn {
    @Element(name = "return", required = false)
    private DetalleExp detalleExp;

    public DetalleExp getDetalleExp() {
        return this.detalleExp;
    }
}
