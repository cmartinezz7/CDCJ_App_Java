package es.santander.justicia.minisJusticia.dto;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import java.io.Serializable;
import java.util.List;

public class ExpedienteDTO implements Serializable, Parent<ExpedientDetailDTO> {
   private boolean detail;
   private String codExpediente;
   private String janoapex;
   private String jnumexp;
   private String jproced;
   private String juzga;
   private String juzgori;
   private String sitexp;
   private String intCostas;
   private String primov;
   private String ultmov;
   private String codmon;
   private String saldo;
   private String moneda;
   private String situacion;
   private List<ExpedientDetailDTO> listDetail;
   private boolean isExpanded;
   private List<SaldoDTO> saldos;

   public boolean isDetail() {
      return this.detail;
   }

   public void setDetail(boolean detail) {
      this.detail = detail;
   }

   public String getCodExpediente() {
      return this.codExpediente;
   }

   public void setCodExpediente(String codExpediente) {
      this.codExpediente = codExpediente;
   }

   public String getJanoapex() {
      return this.janoapex;
   }

   public void setJanoapex(String janoapex) {
      this.janoapex = janoapex;
   }

   public String getJnumexp() {
      return this.jnumexp;
   }

   public void setJnumexp(String jnumexp) {
      this.jnumexp = jnumexp;
   }

   public String getJproced() {
      return this.jproced;
   }

   public void setJproced(String jproced) {
      this.jproced = jproced;
   }

   public String getJuzga() {
      return this.juzga;
   }

   public void setJuzga(String juzga) {
      this.juzga = juzga;
   }

   public String getJuzgori() {
      return this.juzgori;
   }

   public void setJuzgori(String juzgori) {
      this.juzgori = juzgori;
   }

   public String getCodmon() {
      return this.codmon;
   }

   public void setCodmon(String codmon) {
      this.codmon = codmon;
   }

   public String getMoneda() {
      return this.moneda;
   }

   public void setMoneda(String moneda) {
      this.moneda = moneda;
   }

   public String getPrimov() {
      return this.primov;
   }

   public void setPrimov(String primov) {
      this.primov = primov;
   }

   public String getUltmov() {
      return this.ultmov;
   }

   public void setUltmov(String ultmov) {
      this.ultmov = ultmov;
   }

   public String getSaldo() {
      return this.saldo;
   }

   public void setSaldo(String saldo) {
      this.saldo = saldo;
   }

   public String getSituacion() {
      return this.situacion;
   }

   public void setSituacion(String situacion) {
      this.situacion = situacion;
   }

   public String getSitexp() {
      return this.sitexp;
   }

   public void setSitexp(String sitexp) {
      this.sitexp = sitexp;
   }

   public String getIntCostas() {
      return this.intCostas;
   }

   public void setIntCostas(String intCostas) {
      this.intCostas = intCostas;
   }

   public List<SaldoDTO> getSaldos() {
      return this.saldos;
   }

   public void setSaldos(List<SaldoDTO> saldos) {
      this.saldos = saldos;
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
