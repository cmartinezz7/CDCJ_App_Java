package es.santander.justicia.minisJusticia.models.responses.detalleMovimiento;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DatosRepresentante {
    @Element(name = "dmasinfo", required = false)
    private String dmasinfo;
    @Element(name = "genombre", required = false)
    private String genombre;

    public String getDmasinfo() {
        return this.dmasinfo;
    }

    public String getGenombre() {
        return this.genombre;
    }
}
