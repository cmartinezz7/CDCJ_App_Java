package es.santander.justicia.minisJusticia.models.responses;

import es.santander.justicia.minisJusticia.models.responses.buscarExpedientes.Saldos;
import es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail.DetalleExpSaldos;
import org.simpleframework.xml.Element;

public class DatosExpedienteNew {
   @Element(
      name = "codExpAlt",
      required = false
   )
   private String codExpAlt;
   @Element(
      name = "codExpediente",
      required = false
   )
   private String codExpediente;
   @Element(
      name = "codmon",
      required = false
   )
   private String codmon;
   @Element(
      name = "janoapex",
      required = false
   )
   private String janoapex;
   @Element(
      name = "jnumexp",
      required = false
   )
   private String jnumexp;
   @Element(
      name = "jproced",
      required = false
   )
   private String jproced;
   @Element(
      name = "juzga",
      required = false
   )
   private String juzga;
   @Element(
      name = "juzgori",
      required = false
   )
   private String juzgori;
   @Element(
      name = "moneda",
      required = false
   )
   private String moneda;
   @Element(
      name = "primov",
      required = false
   )
   private String primov;
   @Element(
      name = "procedimiento",
      required = false
   )
   private String procedimiento;
   @Element(
      name = "saldos",
      required = false
   )
   private Saldos saldos;
   @Element(
      name = "sitexp",
      required = false
   )
   private String sitexp;
   @Element(
      name = "situacion",
      required = false
   )
   private String situacion;
   @Element(
      name = "ultmov",
      required = false
   )
   private String ultmov;
   @Element(
      name = "numeroPagina",
      required = false
   )
   private int numerPagina;
   @Element(
      name = "tamannoPagina",
      required = false
   )
   private int tamannoPagina;
   @Element(
      name = "totalPaginas",
      required = false
   )
   private int totalPaginas;
   @Element(
      name = "impInterCostas",
      required = false
   )
   private String impInterCostas;
   private boolean isChild;
   private boolean isExpanded;
   private DetalleExpSaldos detalleExpSaldos;

   public boolean isExpanded() {
      return this.isExpanded;
   }

   public void setExpanded(boolean expanded) {
      this.isExpanded = expanded;
   }

   public String getImpInterCostas() {
      return this.impInterCostas;
   }

   public void setImpInterCostas(String impInterCostas) {
      this.impInterCostas = impInterCostas;
   }

   public String getCodExpAlt() {
      return this.codExpAlt;
   }

   public void setCodExpAlt(String codExpAlt) {
      this.codExpAlt = codExpAlt;
   }

   public String getCodExpediente() {
      return this.codExpediente;
   }

   public void setCodExpediente(String codExpediente) {
      this.codExpediente = codExpediente;
   }

   public String getCodmon() {
      return this.codmon;
   }

   public void setCodmon(String codmon) {
      this.codmon = codmon;
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

   public String getProcedimiento() {
      return this.procedimiento;
   }

   public void setProcedimiento(String procedimiento) {
      this.procedimiento = procedimiento;
   }

   public Saldos getSaldos() {
      return this.saldos;
   }

   public void setSaldos(Saldos saldos) {
      this.saldos = saldos;
   }

   public String getSitexp() {
      return this.sitexp;
   }

   public void setSitexp(String sitexp) {
      this.sitexp = sitexp;
   }

   public String getSituacion() {
      return this.situacion;
   }

   public void setSituacion(String situacion) {
      this.situacion = situacion;
   }

   public String getUltmov() {
      return this.ultmov;
   }

   public void setUltmov(String ultmov) {
      this.ultmov = ultmov;
   }

   public int getNumerPagina() {
      return this.numerPagina;
   }

   public void setNumerPagina(int numerPagina) {
      this.numerPagina = numerPagina;
   }

   public int getTamannoPagina() {
      return this.tamannoPagina;
   }

   public void setTamannoPagina(int tamannoPagina) {
      this.tamannoPagina = tamannoPagina;
   }

   public int getTotalPaginas() {
      return this.totalPaginas;
   }

   public void setTotalPaginas(int totalPaginas) {
      this.totalPaginas = totalPaginas;
   }

   public boolean isChild() {
      return this.isChild;
   }

   public void setChild(boolean child) {
      this.isChild = child;
   }

   public DetalleExpSaldos getDetalleExpSaldos() {
      return this.detalleExpSaldos;
   }

   public void setDetalleExpSaldos(DetalleExpSaldos detalleExpSaldos) {
      this.detalleExpSaldos = detalleExpSaldos;
   }

   public DatosExpedienteNew() {
   }

   public DatosExpedienteNew(DetalleExpSaldos detalleExpSaldos) {
      this.isChild = true;
      this.detalleExpSaldos = detalleExpSaldos;
   }
}
