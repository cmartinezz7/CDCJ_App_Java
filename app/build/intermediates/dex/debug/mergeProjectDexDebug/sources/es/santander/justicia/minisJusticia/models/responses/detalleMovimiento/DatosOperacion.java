package es.santander.justicia.minisJusticia.models.responses.detalleMovimiento;

import es.santander.justicia.minisJusticia.models.responses.DatosExpedienteResponse;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DatosOperacion {
    @Element(name = "cdconc", required = false)
    private String cdconc;
    @Element(name = "coddocum ", required = false)
    private String coddocum;
    @Element(name = "codmon", required = false)
    private String codmon;
    @Element(name = "conc30", required = false)
    private String conc30;
    @Element(name = "datosActuacionPolicial", required = false)
    private String datosActuacionPolicial;
    @Element(name = "datosAdicionales", required = false)
    private String datosAdicionales;
    @Element(name = "datosExpediente", required = false)
    private DatosExpedienteResponse datosExpediente;
    @Element(name = "datosExpedienteDestino", required = false)
    private DatosExpedienteDestino datosExpedienteDestino;
    @Element(name = "datosFirma", required = false)
    private DatosFirma datosFirma;
    @Element(name = "datosInterviniente", required = false)
    private String datosInterviniente;
    @Element(name = "datosJuzgadoPaz", required = false)
    private String datosJuzgadoPaz;
    @Element(name = "datosMaterializacion", required = false)
    private DatosMaterializacion datosMaterializacion;
    @Element(name = "datosRepresentante", required = false)
    private DatosRepresentante datosRepresentante;
    @Element(name = "desctipomod", required = false)
    private String desctipomod;
    @Element(name = "indres", required = false)
    private String indres;
    @Element(name = "jfecautoriza", required = false)
    private String jfecautoriza;
    @Element(name = "jfeccaduc", required = false)
    private String jfeccaduc;
    @Element(name = "jfecconf", required = false)
    private String jfecconf;
    @Element(name = "jfecfirma", required = false)
    private String jfecfirma;
    @Element(name = "jfecfirmeza", required = false)
    private String jfecfirmeza;
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
    @Element(name = "jobs", required = false)
    private String jobs;
    @Element(name = "jtipopera", required = false)
    private String jtipopera;
    @Element(name = "jusrautoriza", required = false)
    private String jusrautoriza;
    @Element(name = "jusrconf", required = false)
    private String jusrconf;
    @Element(name = "jusrfirma", required = false)
    private String jusrfirma;
    @Element(name = "jusrfirmeza", required = false)
    private String jusrfirmeza;
    @Element(name = "jusrhare", required = false)
    private String jusrhare;
    @Element(name = "motivoSolicitud", required = false)
    private String motivoSolicitud;
    @Element(name = "numerosr", required = false)
    private String numerosr;
    @Element(name = "seralfab", required = false)
    private String seralfab;
    @Element(name = "serieYMandamiento", required = false)
    private String serieYMandamiento;

    public String getCdconc() {
        return this.cdconc;
    }

    public String getCodmon() {
        return this.codmon;
    }

    public String getConc30() {
        return this.conc30;
    }

    public String getDatosActuacionPolicial() {
        return this.datosActuacionPolicial;
    }

    public String getDatosAdicionales() {
        return this.datosAdicionales;
    }

    public DatosExpedienteResponse getDatosExpediente() {
        return this.datosExpediente;
    }

    public DatosExpedienteDestino getDatosExpedienteDestino() {
        return this.datosExpedienteDestino;
    }

    public DatosFirma getDatosFirma() {
        return this.datosFirma;
    }

    public String getDatosInterviniente() {
        return this.datosInterviniente;
    }

    public String getDatosJuzgadoPaz() {
        return this.datosJuzgadoPaz;
    }

    public DatosMaterializacion getDatosMaterializacion() {
        return this.datosMaterializacion;
    }

    public DatosRepresentante getDatosRepresentante() {
        return this.datosRepresentante;
    }

    public String getDesctipomod() {
        return this.desctipomod;
    }

    public String getIndres() {
        return this.indres;
    }

    public String getJfeccaduc() {
        return this.jfeccaduc;
    }

    public String getJfecconf() {
        return this.jfecconf;
    }

    public String getJfecfirma() {
        return this.jfecfirma;
    }

    public String getJfechare() {
        return this.jfechare;
    }

    public String getJnuoper() {
        return this.jnuoper;
    }

    public String getJobs() {
        return this.jobs;
    }

    public String getJtipopera() {
        return this.jtipopera;
    }

    public String getJusrconf() {
        return this.jusrconf;
    }

    public String getJusrfirma() {
        return this.jusrfirma;
    }

    public String getJusrhare() {
        return this.jusrhare;
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

    public String getJfecfirmeza() {
        return this.jfecfirmeza;
    }

    public String getJfecautoriza() {
        return this.jfecautoriza;
    }

    public String getJusrfirmeza() {
        return this.jusrfirmeza;
    }

    public String getJusrautoriza() {
        return this.jusrautoriza;
    }

    public String getJnors() {
        return this.jnors;
    }

    public String getCoddocum() {
        return this.coddocum;
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

    public String getMotivoSolicitud() {
        return this.motivoSolicitud;
    }
}
