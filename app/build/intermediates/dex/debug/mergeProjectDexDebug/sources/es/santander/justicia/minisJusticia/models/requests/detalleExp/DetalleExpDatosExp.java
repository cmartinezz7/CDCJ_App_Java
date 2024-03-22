package es.santander.justicia.minisJusticia.models.requests.detalleExp;

import org.simpleframework.xml.Element;

public class DetalleExpDatosExp {
    @Element(name = "datosExpediente", required = false)
    private DetalleExpDatosExpDetail datosExpediente;

    public DetalleExpDatosExp(DetalleExpDatosExpDetail datosExpediente2) {
        this.datosExpediente = datosExpediente2;
    }
}
