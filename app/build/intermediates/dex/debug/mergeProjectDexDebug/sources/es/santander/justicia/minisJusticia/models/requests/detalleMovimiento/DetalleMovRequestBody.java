package es.santander.justicia.minisJusticia.models.requests.detalleMovimiento;

import org.simpleframework.xml.Element;

public class DetalleMovRequestBody {
    @Element(name = "wsj:detalleMovimiento", required = false)
    private DetalleMovArg0 detalleMovArg0;

    public DetalleMovRequestBody(DetalleMovArg0 detalleMovArg02) {
        this.detalleMovArg0 = detalleMovArg02;
    }
}
