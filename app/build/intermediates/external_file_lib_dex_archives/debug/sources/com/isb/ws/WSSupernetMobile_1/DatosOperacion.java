package com.isb.ws.WSSupernetMobile_1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosOperacion", propOrder = {"cdconc", "coddocum", "codmon", "codpost", "conc30", "datosActuacionPolicial", "datosAdicionales", "datosExpediente", "datosExpedienteDestino", "datosFirma", "datosInterviniente", "datosJuzgadoPaz", "datosMaterializacion", "datosRepresentante", "desanul", "desautoriza", "desctipomod", "fecreop", "idtipvia", "indres", "jasiento", "jcodpais", "jcodprov", "jcodpza", "jfecanul", "jfecautoriza", "jfeccaduc", "jfecconf", "jfecfirma", "jfecfirmeza", "jfechare", "jimpcaduca", "jimpnomi", "jimppend", "jnors", "jnuoper", "jnuopera", "jobs", "jtipomod", "jusrautoriza", "jusrcaduc", "jusrcanul", "jusrconf", "jusrfirma", "jusrhare", "moneda", "nomvia", "numerosr", "numvia", "nurefc", "pais", "plaza", "provincia", "recurso", "seralfab", "serieYMandamiento", "subtipco", "telefono", "tipdoc", "tipmovim", "tipoDocumento", "tipoVia"})
public class DatosOperacion {
    protected String cdconc;
    protected String coddocum;
    protected String codmon;
    protected String codpost;
    protected String conc30;
    protected DatosActuacionPolicial datosActuacionPolicial;
    protected DatosAdicionales datosAdicionales;
    protected DatosExpediente datosExpediente;
    protected DatosExpediente datosExpedienteDestino;
    protected DatosFirma datosFirma;
    protected DatosInterviniente datosInterviniente;
    protected DatosJuzgadoPaz datosJuzgadoPaz;
    protected DatosMaterializacion datosMaterializacion;
    protected DatosRepresentante datosRepresentante;
    protected String desanul;
    protected String desautoriza;
    protected String desctipomod;
    protected String fecreop;
    protected String idtipvia;
    protected String indres;
    protected String jasiento;
    protected String jcodpais;
    protected String jcodprov;
    protected String jcodpza;
    protected String jfecanul;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar jfecautoriza;
    protected String jfeccaduc;
    protected String jfecconf;
    protected String jfecfirma;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar jfecfirmeza;
    protected String jfechare;
    protected BigDecimal jimpcaduca;
    protected BigDecimal jimpnomi;
    protected BigDecimal jimppend;
    protected String jnors;
    protected Long jnuoper;
    protected Long jnuopera;
    protected String jobs;
    protected String jtipomod;
    protected String jusrautoriza;
    protected String jusrcaduc;
    protected String jusrcanul;
    protected String jusrconf;
    protected String jusrfirma;
    protected String jusrhare;
    protected String moneda;
    protected String nomvia;
    protected String numerosr;
    protected String numvia;
    protected String nurefc;
    protected String pais;
    protected String plaza;
    protected String provincia;
    protected String recurso;
    protected String seralfab;
    protected String serieYMandamiento;
    protected String subtipco;
    protected String telefono;
    protected String tipdoc;
    protected String tipmovim;
    protected String tipoDocumento;
    protected String tipoVia;

    public String getCdconc() {
        return this.cdconc;
    }

    public void setCdconc(String str) {
        this.cdconc = str;
    }

    public String getCoddocum() {
        return this.coddocum;
    }

    public void setCoddocum(String str) {
        this.coddocum = str;
    }

    public String getCodmon() {
        return this.codmon;
    }

    public void setCodmon(String str) {
        this.codmon = str;
    }

    public String getCodpost() {
        return this.codpost;
    }

    public void setCodpost(String str) {
        this.codpost = str;
    }

    public String getConc30() {
        return this.conc30;
    }

    public void setConc30(String str) {
        this.conc30 = str;
    }

    public DatosActuacionPolicial getDatosActuacionPolicial() {
        return this.datosActuacionPolicial;
    }

    public void setDatosActuacionPolicial(DatosActuacionPolicial datosActuacionPolicial2) {
        this.datosActuacionPolicial = datosActuacionPolicial2;
    }

    public DatosAdicionales getDatosAdicionales() {
        return this.datosAdicionales;
    }

    public void setDatosAdicionales(DatosAdicionales datosAdicionales2) {
        this.datosAdicionales = datosAdicionales2;
    }

    public DatosExpediente getDatosExpediente() {
        return this.datosExpediente;
    }

    public void setDatosExpediente(DatosExpediente datosExpediente2) {
        this.datosExpediente = datosExpediente2;
    }

    public DatosExpediente getDatosExpedienteDestino() {
        return this.datosExpedienteDestino;
    }

    public void setDatosExpedienteDestino(DatosExpediente datosExpediente2) {
        this.datosExpedienteDestino = datosExpediente2;
    }

    public DatosFirma getDatosFirma() {
        return this.datosFirma;
    }

    public void setDatosFirma(DatosFirma datosFirma2) {
        this.datosFirma = datosFirma2;
    }

    public DatosInterviniente getDatosInterviniente() {
        return this.datosInterviniente;
    }

    public void setDatosInterviniente(DatosInterviniente datosInterviniente2) {
        this.datosInterviniente = datosInterviniente2;
    }

    public DatosJuzgadoPaz getDatosJuzgadoPaz() {
        return this.datosJuzgadoPaz;
    }

    public void setDatosJuzgadoPaz(DatosJuzgadoPaz datosJuzgadoPaz2) {
        this.datosJuzgadoPaz = datosJuzgadoPaz2;
    }

    public DatosMaterializacion getDatosMaterializacion() {
        return this.datosMaterializacion;
    }

    public void setDatosMaterializacion(DatosMaterializacion datosMaterializacion2) {
        this.datosMaterializacion = datosMaterializacion2;
    }

    public DatosRepresentante getDatosRepresentante() {
        return this.datosRepresentante;
    }

    public void setDatosRepresentante(DatosRepresentante datosRepresentante2) {
        this.datosRepresentante = datosRepresentante2;
    }

    public String getDesanul() {
        return this.desanul;
    }

    public void setDesanul(String str) {
        this.desanul = str;
    }

    public String getDesautoriza() {
        return this.desautoriza;
    }

    public void setDesautoriza(String str) {
        this.desautoriza = str;
    }

    public String getDesctipomod() {
        return this.desctipomod;
    }

    public void setDesctipomod(String str) {
        this.desctipomod = str;
    }

    public String getFecreop() {
        return this.fecreop;
    }

    public void setFecreop(String str) {
        this.fecreop = str;
    }

    public String getIdtipvia() {
        return this.idtipvia;
    }

    public void setIdtipvia(String str) {
        this.idtipvia = str;
    }

    public String getIndres() {
        return this.indres;
    }

    public void setIndres(String str) {
        this.indres = str;
    }

    public String getJasiento() {
        return this.jasiento;
    }

    public void setJasiento(String str) {
        this.jasiento = str;
    }

    public String getJcodpais() {
        return this.jcodpais;
    }

    public void setJcodpais(String str) {
        this.jcodpais = str;
    }

    public String getJcodprov() {
        return this.jcodprov;
    }

    public void setJcodprov(String str) {
        this.jcodprov = str;
    }

    public String getJcodpza() {
        return this.jcodpza;
    }

    public void setJcodpza(String str) {
        this.jcodpza = str;
    }

    public String getJfecanul() {
        return this.jfecanul;
    }

    public void setJfecanul(String str) {
        this.jfecanul = str;
    }

    public XMLGregorianCalendar getJfecautoriza() {
        return this.jfecautoriza;
    }

    public void setJfecautoriza(XMLGregorianCalendar xMLGregorianCalendar) {
        this.jfecautoriza = xMLGregorianCalendar;
    }

    public String getJfeccaduc() {
        return this.jfeccaduc;
    }

    public void setJfeccaduc(String str) {
        this.jfeccaduc = str;
    }

    public String getJfecconf() {
        return this.jfecconf;
    }

    public void setJfecconf(String str) {
        this.jfecconf = str;
    }

    public String getJfecfirma() {
        return this.jfecfirma;
    }

    public void setJfecfirma(String str) {
        this.jfecfirma = str;
    }

    public XMLGregorianCalendar getJfecfirmeza() {
        return this.jfecfirmeza;
    }

    public void setJfecfirmeza(XMLGregorianCalendar xMLGregorianCalendar) {
        this.jfecfirmeza = xMLGregorianCalendar;
    }

    public String getJfechare() {
        return this.jfechare;
    }

    public void setJfechare(String str) {
        this.jfechare = str;
    }

    public BigDecimal getJimpcaduca() {
        return this.jimpcaduca;
    }

    public void setJimpcaduca(BigDecimal bigDecimal) {
        this.jimpcaduca = bigDecimal;
    }

    public BigDecimal getJimpnomi() {
        return this.jimpnomi;
    }

    public void setJimpnomi(BigDecimal bigDecimal) {
        this.jimpnomi = bigDecimal;
    }

    public BigDecimal getJimppend() {
        return this.jimppend;
    }

    public void setJimppend(BigDecimal bigDecimal) {
        this.jimppend = bigDecimal;
    }

    public String getJnors() {
        return this.jnors;
    }

    public void setJnors(String str) {
        this.jnors = str;
    }

    public Long getJnuoper() {
        return this.jnuoper;
    }

    public void setJnuoper(Long l) {
        this.jnuoper = l;
    }

    public Long getJnuopera() {
        return this.jnuopera;
    }

    public void setJnuopera(Long l) {
        this.jnuopera = l;
    }

    public String getJobs() {
        return this.jobs;
    }

    public void setJobs(String str) {
        this.jobs = str;
    }

    public String getJtipomod() {
        return this.jtipomod;
    }

    public void setJtipomod(String str) {
        this.jtipomod = str;
    }

    public String getJusrautoriza() {
        return this.jusrautoriza;
    }

    public void setJusrautoriza(String str) {
        this.jusrautoriza = str;
    }

    public String getJusrcaduc() {
        return this.jusrcaduc;
    }

    public void setJusrcaduc(String str) {
        this.jusrcaduc = str;
    }

    public String getJusrcanul() {
        return this.jusrcanul;
    }

    public void setJusrcanul(String str) {
        this.jusrcanul = str;
    }

    public String getJusrconf() {
        return this.jusrconf;
    }

    public void setJusrconf(String str) {
        this.jusrconf = str;
    }

    public String getJusrfirma() {
        return this.jusrfirma;
    }

    public void setJusrfirma(String str) {
        this.jusrfirma = str;
    }

    public String getJusrhare() {
        return this.jusrhare;
    }

    public void setJusrhare(String str) {
        this.jusrhare = str;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String str) {
        this.moneda = str;
    }

    public String getNomvia() {
        return this.nomvia;
    }

    public void setNomvia(String str) {
        this.nomvia = str;
    }

    public String getNumerosr() {
        return this.numerosr;
    }

    public void setNumerosr(String str) {
        this.numerosr = str;
    }

    public String getNumvia() {
        return this.numvia;
    }

    public void setNumvia(String str) {
        this.numvia = str;
    }

    public String getNurefc() {
        return this.nurefc;
    }

    public void setNurefc(String str) {
        this.nurefc = str;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String str) {
        this.pais = str;
    }

    public String getPlaza() {
        return this.plaza;
    }

    public void setPlaza(String str) {
        this.plaza = str;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public void setProvincia(String str) {
        this.provincia = str;
    }

    public String getRecurso() {
        return this.recurso;
    }

    public void setRecurso(String str) {
        this.recurso = str;
    }

    public String getSeralfab() {
        return this.seralfab;
    }

    public void setSeralfab(String str) {
        this.seralfab = str;
    }

    public String getSerieYMandamiento() {
        return this.serieYMandamiento;
    }

    public void setSerieYMandamiento(String str) {
        this.serieYMandamiento = str;
    }

    public String getSubtipco() {
        return this.subtipco;
    }

    public void setSubtipco(String str) {
        this.subtipco = str;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String str) {
        this.telefono = str;
    }

    public String getTipdoc() {
        return this.tipdoc;
    }

    public void setTipdoc(String str) {
        this.tipdoc = str;
    }

    public String getTipmovim() {
        return this.tipmovim;
    }

    public void setTipmovim(String str) {
        this.tipmovim = str;
    }

    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(String str) {
        this.tipoDocumento = str;
    }

    public String getTipoVia() {
        return this.tipoVia;
    }

    public void setTipoVia(String str) {
        this.tipoVia = str;
    }
}
