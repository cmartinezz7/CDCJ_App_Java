package es.santander.justicia.minisJusticia.models.responses.detalleExpediente;

import org.simpleframework.xml.Element;

public class DetalleExp {
    @Element(name = "datosExpediente", required = false)
    private DetalleExpDatosExpDetail detalleExpDatosExpDetail;

    public DetalleExpDatosExpDetail getDetalleExpDatosExpDetail() {
        return this.detalleExpDatosExpDetail;
    }
}
