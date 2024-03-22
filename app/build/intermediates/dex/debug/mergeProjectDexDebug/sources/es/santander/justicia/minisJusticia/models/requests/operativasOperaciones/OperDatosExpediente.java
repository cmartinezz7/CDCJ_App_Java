package es.santander.justicia.minisJusticia.models.requests.operativasOperaciones;

import org.simpleframework.xml.Element;

public class OperDatosExpediente {
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
    @Element(name = "saldos", required = false)
    private String saldos = "";

    public OperDatosExpediente(String codExpediente2, String janoapex2, String jnumexp2, String jproced2, String juzga2, String juzgori2) {
        this.codExpediente = codExpediente2;
        this.janoapex = janoapex2;
        this.jnumexp = jnumexp2;
        this.jproced = jproced2;
        this.juzga = juzga2;
        this.juzgori = juzgori2;
    }
}
