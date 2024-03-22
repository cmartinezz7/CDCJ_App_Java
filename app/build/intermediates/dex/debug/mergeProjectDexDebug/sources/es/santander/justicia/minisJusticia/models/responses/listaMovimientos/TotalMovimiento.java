package es.santander.justicia.minisJusticia.models.responses.listaMovimientos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class TotalMovimiento {
    @Element(name = "codmon", required = false)
    private String codmon;
    @Element(name = "jimpabono", required = false)
    private String jimpabono;
    @Element(name = "jimpcargo", required = false)
    private String jimpcargo;
    @Element(name = "jimppend", required = false)
    private String jimppend;
    @Element(name = "moneda", required = false)
    private String moneda;

    public String getCodmon() {
        return this.codmon;
    }

    public String getJimpabono() {
        return this.jimpabono;
    }

    public String getJimpcargo() {
        return this.jimpcargo;
    }

    public String getJimppend() {
        return this.jimppend;
    }

    public String getMoneda() {
        return this.moneda;
    }
}
