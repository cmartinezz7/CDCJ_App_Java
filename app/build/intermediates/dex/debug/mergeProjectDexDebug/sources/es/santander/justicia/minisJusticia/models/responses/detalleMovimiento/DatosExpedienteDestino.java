package es.santander.justicia.minisJusticia.models.responses.detalleMovimiento;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DatosExpedienteDestino {
    @Element(name = "codExpAlt", required = false)
    private String codExpAlt;
    @Element(name = "codExpediente", required = false)
    private String codExpediente;
    @Element(name = "janoapex", required = false)
    private String janoapex;
    @Element(name = "jnumexp", required = false)
    private String jnumexp;
    @Element(name = "jproced", required = false)
    private String jproced;
    @Element(name = "juzga", required = false)
    private String juzga;
    @Element(name = "juzgori", required = false)
    private String juzgori;

    public String getCodExpAlt() {
        return this.codExpAlt;
    }

    public String getCodExpediente() {
        return this.codExpediente;
    }

    public String getJanoapex() {
        return this.janoapex;
    }

    public String getJnumexp() {
        return this.jnumexp;
    }

    public String getJproced() {
        return this.jproced;
    }

    public String getJuzga() {
        return this.juzga;
    }

    public String getJuzgori() {
        return this.juzgori;
    }
}
