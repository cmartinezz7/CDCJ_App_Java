package es.santander.justicia.minisJusticia.models.responses.buscarExpedientes;

import org.simpleframework.xml.Element;

public class Saldos {
    @Element(name = "codmon", required = false)
    private String codmon;
    @Element(name = "impsaldo", required = false)
    private String impsald;
    @Element(name = "moneda", required = false)
    private String moneda;
    @Element(name = "principal", required = false)
    private String principal;

    public String getCodmon() {
        return this.codmon;
    }

    public String getImpsald() {
        return this.impsald;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public String getPrincipal() {
        return this.principal;
    }
}
