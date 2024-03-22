package es.santander.justicia.minisJusticia.models.responses.detalleMovimiento;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DatosFirma {
    @Element(name = "indicadorFirma", required = false)
    private String indicadorFirma;
    @Element(name = "numeroPersona", required = false)
    private String numeroPersona;
    @Element(name = "tipoPersona", required = false)
    private String tipoPersona;

    public String getIndicadorFirma() {
        return this.indicadorFirma;
    }

    public String getNumeroPersona() {
        return this.numeroPersona;
    }

    public String getTipoPersona() {
        return this.tipoPersona;
    }
}
