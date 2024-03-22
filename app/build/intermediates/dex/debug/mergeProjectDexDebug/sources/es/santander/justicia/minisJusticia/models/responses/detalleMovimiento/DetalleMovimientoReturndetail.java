package es.santander.justicia.minisJusticia.models.responses.detalleMovimiento;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DetalleMovimientoReturndetail {
    @Element(name = "datosOperacion", required = false)
    private DatosOperacion datosOperacion;

    public DatosOperacion getDatosOperacion() {
        return this.datosOperacion;
    }
}
