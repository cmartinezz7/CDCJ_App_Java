package com.isb.ws.WSSupernetMobile_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosExpediente", propOrder = {"codExpAlt", "codExpediente", "codmon", "codprior", "janoapex", "jnumexp", "jproced", "juzga", "juzgado", "juzgori", "moneda", "numExpediente", "primov", "prioridad", "procedimiento", "saldos", "sitexp", "situacion", "ultmov"})
public class DatosExpediente {
    protected Long codExpAlt;
    protected String codExpediente;
    protected String codmon;
    protected String codprior;
    protected String janoapex;
    protected Long jnumexp;
    protected String jproced;
    protected String juzga;
    protected String juzgado;
    protected String juzgori;
    protected String moneda;
    protected String numExpediente;
    protected String primov;
    protected String prioridad;
    protected String procedimiento;
    @XmlElement(nillable = true)
    protected List<DatosSaldo> saldos;
    protected String sitexp;
    protected String situacion;
    protected String ultmov;

    public Long getCodExpAlt() {
        return this.codExpAlt;
    }

    public void setCodExpAlt(Long l) {
        this.codExpAlt = l;
    }

    public String getCodExpediente() {
        return this.codExpediente;
    }

    public void setCodExpediente(String str) {
        this.codExpediente = str;
    }

    public String getCodmon() {
        return this.codmon;
    }

    public void setCodmon(String str) {
        this.codmon = str;
    }

    public String getCodprior() {
        return this.codprior;
    }

    public void setCodprior(String str) {
        this.codprior = str;
    }

    public String getJanoapex() {
        return this.janoapex;
    }

    public void setJanoapex(String str) {
        this.janoapex = str;
    }

    public Long getJnumexp() {
        return this.jnumexp;
    }

    public void setJnumexp(Long l) {
        this.jnumexp = l;
    }

    public String getJproced() {
        return this.jproced;
    }

    public void setJproced(String str) {
        this.jproced = str;
    }

    public String getJuzga() {
        return this.juzga;
    }

    public void setJuzga(String str) {
        this.juzga = str;
    }

    public String getJuzgado() {
        return this.juzgado;
    }

    public void setJuzgado(String str) {
        this.juzgado = str;
    }

    public String getJuzgori() {
        return this.juzgori;
    }

    public void setJuzgori(String str) {
        this.juzgori = str;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String str) {
        this.moneda = str;
    }

    public String getNumExpediente() {
        return this.numExpediente;
    }

    public void setNumExpediente(String str) {
        this.numExpediente = str;
    }

    public String getPrimov() {
        return this.primov;
    }

    public void setPrimov(String str) {
        this.primov = str;
    }

    public String getPrioridad() {
        return this.prioridad;
    }

    public void setPrioridad(String str) {
        this.prioridad = str;
    }

    public String getProcedimiento() {
        return this.procedimiento;
    }

    public void setProcedimiento(String str) {
        this.procedimiento = str;
    }

    public List<DatosSaldo> getSaldos() {
        if (this.saldos == null) {
            this.saldos = new ArrayList();
        }
        return this.saldos;
    }

    public String getSitexp() {
        return this.sitexp;
    }

    public void setSitexp(String str) {
        this.sitexp = str;
    }

    public String getSituacion() {
        return this.situacion;
    }

    public void setSituacion(String str) {
        this.situacion = str;
    }

    public String getUltmov() {
        return this.ultmov;
    }

    public void setUltmov(String str) {
        this.ultmov = str;
    }
}
