package es.santander.justicia.minisJusticia.models.requests.buscPetAcceso;

import es.santander.justicia.minisJusticia.models.requests.DatosPaginacionRequest;
import org.simpleframework.xml.Element;

public class BuscPetArg0Detail {
    @Element(name = "codEstadoPeticion", required = false)
    private String codEstadoPeticion;
    @Element(name = "datosPaginacion", required = false)
    private DatosPaginacionRequest datosPaginacionRequest;
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

    public void setDatosPaginacionRequest(DatosPaginacionRequest datosPaginacionRequest2) {
        this.datosPaginacionRequest = datosPaginacionRequest2;
    }

    public void setJuzga(String juzga2) {
        this.juzga = juzga2;
    }

    public void setJuzgori(String juzgori2) {
        this.juzgori = juzgori2;
    }

    public void setJproced(String jproced2) {
        this.jproced = jproced2;
    }

    public void setJnumexp(String jnumexp2) {
        this.jnumexp = jnumexp2;
    }

    public void setJanoapex(String janoapex2) {
        this.janoapex = janoapex2;
    }

    public void setCodEstadoPeticion(String codEstadoPeticion2) {
        this.codEstadoPeticion = codEstadoPeticion2;
    }
}
