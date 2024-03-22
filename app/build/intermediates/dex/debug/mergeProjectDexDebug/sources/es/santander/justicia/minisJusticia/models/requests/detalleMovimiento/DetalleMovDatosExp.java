package es.santander.justicia.minisJusticia.models.requests.detalleMovimiento;

import org.simpleframework.xml.Element;

public class DetalleMovDatosExp {
    @Element(name = "juzga", required = false)
    private String juzga;

    public DetalleMovDatosExp(String juzga2) {
        this.juzga = juzga2;
    }
}
