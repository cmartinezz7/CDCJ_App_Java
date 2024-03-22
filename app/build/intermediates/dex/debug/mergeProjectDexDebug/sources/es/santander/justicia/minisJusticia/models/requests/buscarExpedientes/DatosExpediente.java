package es.santander.justicia.minisJusticia.models.requests.buscarExpedientes;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DatosExpediente {
    @Element(name = "codmon", required = false)
    private String codmon;
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
    @Element(name = "sitexp", required = false)
    private String sitexp;

    public DatosExpediente(String juzga2, String juzgori2, String jproced2, String jnumexp2, String janoapex2, String codmon2, String sitexp2) {
        if (juzga2 != null) {
            this.juzga = juzga2;
        }
        if (juzgori2 != null) {
            this.juzgori = juzgori2;
        }
        if (jproced2 != null) {
            this.jproced = jproced2;
        }
        if (jnumexp2 != null) {
            this.jnumexp = jnumexp2;
        }
        if (janoapex2 != null) {
            this.janoapex = janoapex2;
        }
        if (codmon2 != null) {
            this.codmon = codmon2;
        }
        if (sitexp2 != null) {
            this.sitexp = sitexp2;
        }
    }
}
