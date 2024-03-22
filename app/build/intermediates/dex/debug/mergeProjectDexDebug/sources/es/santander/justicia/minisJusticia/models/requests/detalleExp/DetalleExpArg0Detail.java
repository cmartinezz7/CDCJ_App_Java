package es.santander.justicia.minisJusticia.models.requests.detalleExp;

import org.simpleframework.xml.Element;

public class DetalleExpArg0Detail {
    @Element(name = "datosAcceso")
    private DetalleExpDatosExp detalleExpDatosExp;

    public DetalleExpArg0Detail(DetalleExpDatosExp detalleExpDatosExp2) {
        this.detalleExpDatosExp = detalleExpDatosExp2;
    }
}
