package es.santander.justicia.minisJusticia.models.requests.detalleMovimiento;

import org.simpleframework.xml.Element;

public class DetalleMovArg0Detail {
    @Element(name = "datosOperacion", required = false)
    private DetalleMovDatosOperRequest detalleMovDatosOperRequest;

    public DetalleMovArg0Detail(DetalleMovDatosOperRequest detalleMovDatosOperRequest2) {
        this.detalleMovDatosOperRequest = detalleMovDatosOperRequest2;
    }
}
