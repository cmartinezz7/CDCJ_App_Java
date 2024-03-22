package es.santander.justicia.minisJusticia.dto;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import java.io.Serializable;
import java.util.List;

public class ExpedienteDTO implements Serializable, Parent<ExpedientDetailDTO> {
    private String codExpediente;
    private String codmon;
    private boolean detail;
    private String intCostas;
    private boolean isExpanded;
    private String janoapex;
    private String jnumexp;
    private String jproced;
    private String juzga;
    private String juzgori;
    private List<ExpedientDetailDTO> listDetail;
    private String moneda;
    private String primov;
    private String saldo;
    private List<SaldoDTO> saldos;
    private String sitexp;
    private String situacion;
    private String ultmov;

    public boolean isDetail() {
        return this.detail;
    }

    public void setDetail(boolean detail2) {
        this.detail = detail2;
    }

    public String getCodExpediente() {
        return this.codExpediente;
    }

    public void setCodExpediente(String codExpediente2) {
        this.codExpediente = codExpediente2;
    }

    public String getJanoapex() {
        return this.janoapex;
    }

    public void setJanoapex(String janoapex2) {
        this.janoapex = janoapex2;
    }

    public String getJnumexp() {
        return this.jnumexp;
    }

    public void setJnumexp(String jnumexp2) {
        this.jnumexp = jnumexp2;
    }

    public String getJproced() {
        return this.jproced;
    }

    public void setJproced(String jproced2) {
        this.jproced = jproced2;
    }

    public String getJuzga() {
        return this.juzga;
    }

    public void setJuzga(String juzga2) {
        this.juzga = juzga2;
    }

    public String getJuzgori() {
        return this.juzgori;
    }

    public void setJuzgori(String juzgori2) {
        this.juzgori = juzgori2;
    }

    public String getCodmon() {
        return this.codmon;
    }

    public void setCodmon(String codmon2) {
        this.codmon = codmon2;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda2) {
        this.moneda = moneda2;
    }

    public String getPrimov() {
        return this.primov;
    }

    public void setPrimov(String primov2) {
        this.primov = primov2;
    }

    public String getUltmov() {
        return this.ultmov;
    }

    public void setUltmov(String ultmov2) {
        this.ultmov = ultmov2;
    }

    public String getSaldo() {
        return this.saldo;
    }

    public void setSaldo(String saldo2) {
        this.saldo = saldo2;
    }

    public String getSituacion() {
        return this.situacion;
    }

    public void setSituacion(String situacion2) {
        this.situacion = situacion2;
    }

    public String getSitexp() {
        return this.sitexp;
    }

    public void setSitexp(String sitexp2) {
        this.sitexp = sitexp2;
    }

    public String getIntCostas() {
        return this.intCostas;
    }

    public void setIntCostas(String intCostas2) {
        this.intCostas = intCostas2;
    }

    public List<SaldoDTO> getSaldos() {
        return this.saldos;
    }

    public void setSaldos(List<SaldoDTO> saldos2) {
        this.saldos = saldos2;
    }

    public String toString() {
        return "ExpedienteDTO{janoapex='" + this.janoapex + '\'' + ", jnumexp='" + this.jnumexp + '\'' + ", jproced='" + this.jproced + '\'' + ", juzga='" + this.juzga + '\'' + ", juzgori='" + this.juzgori + '\'' + '}';
    }

    public void setListDetail(List<ExpedientDetailDTO> details) {
        this.listDetail = details;
    }

    public void setExpanded(boolean expanded) {
        this.isExpanded = expanded;
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public List<ExpedientDetailDTO> getChildList() {
        return this.listDetail;
    }

    public boolean isInitiallyExpanded() {
        return false;
    }
}
