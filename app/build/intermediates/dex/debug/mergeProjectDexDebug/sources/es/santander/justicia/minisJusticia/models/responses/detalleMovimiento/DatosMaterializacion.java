package es.santander.justicia.minisJusticia.models.responses.detalleMovimiento;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DatosMaterializacion {
    @Element(name = "idcenta", required = false)
    private String idcenta;
    @Element(name = "idempra", required = false)
    private String idempra;
    @Element(name = "numdgo", required = false)
    private String numdgo;

    public String getIdcenta() {
        return this.idcenta;
    }

    public String getIdempra() {
        return this.idempra;
    }

    public String getNumdgo() {
        return this.numdgo;
    }
}
