package es.santander.justicia.minisJusticia.models.responses.detalleMovimiento;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DetalleMovimientoReturn {
    @Element(name = "return", required = false)
    private DetalleMovimientoReturndetail detalleMovimientoReturndetail;

    public DetalleMovimientoReturndetail getDetalleMovimientoReturndetail() {
        return this.detalleMovimientoReturndetail;
    }
}
