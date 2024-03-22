package es.santander.justicia.minisJusticia.models.responses.listaMovimientos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DatosOperacion {
    @Element(name = "codmon", required = false)
    private String codmon;
    @Element(name = "desctipomod", required = false)
    private String desctipomod;
    @Element(name = "jfechare", required = false)
    private String jfechare;
    @Element(name = "jimpcaduca", required = false)
    private String jimpcaduca;
    @Element(name = "jimpnomi", required = false)
    private String jimpnomi;
    @Element(name = "jimppend", required = false)
    private String jimppend;
    @Element(name = "jnors", required = false)
    private String jnors;
    @Element(name = "jnuoper", required = false)
    private String jnuoper;
    @Element(name = "jtipomod", required = false)
    private String jtipomod;
    @Element(name = "moneda", required = false)
    private String moneda;
    @Element(name = "numerosr", required = false)
    private String numerosr;
    @Element(name = "seralfab", required = false)
    private String seralfab;
    @Element(name = "serieYMandamiento", required = false)
    private String serieYMandamiento;

    public String getCodmon() {
        return this.codmon;
    }

    public String getDesctipomod() {
        return this.desctipomod;
    }

    public String getJfechare() {
        return this.jfechare;
    }

    public String getJimpnomi() {
        return this.jimpnomi;
    }

    public String getJimppend() {
        return this.jimppend;
    }

    public String getJimpcaduca() {
        return this.jimpcaduca;
    }

    public String getJnors() {
        return this.jnors;
    }

    public String getJnuoper() {
        return this.jnuoper;
    }

    public String getJtipomod() {
        return this.jtipomod;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public String getNumerosr() {
        return this.numerosr;
    }

    public String getSeralfab() {
        return this.seralfab;
    }

    public String getSerieYMandamiento() {
        return this.serieYMandamiento;
    }
}
