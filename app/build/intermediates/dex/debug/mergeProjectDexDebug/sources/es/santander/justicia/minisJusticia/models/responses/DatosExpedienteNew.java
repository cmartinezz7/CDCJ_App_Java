package es.santander.justicia.minisJusticia.models.responses;

import es.santander.justicia.minisJusticia.models.responses.buscarExpedientes.Saldos;
import es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail;
import org.simpleframework.xml.Element;

public class DatosExpedienteNew {
    @Element(name = "codExpAlt", required = false)
    private String codExpAlt;
    @Element(name = "codExpediente", required = false)
    private String codExpediente;
    @Element(name = "codmon", required = false)
    private String codmon;
    private DetalleExpDatosExpDetail.DetalleExpSaldos detalleExpSaldos;
    @Element(name = "impInterCostas", required = false)
    private String impInterCostas;
    private boolean isChild;
    private boolean isExpanded;
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
    @Element(name = "moneda", required = false)
    private String moneda;
    @Element(name = "numeroPagina", required = false)
    private int numerPagina;
    @Element(name = "primov", required = false)
    private String primov;
    @Element(name = "procedimiento", required = false)
    private String procedimiento;
    @Element(name = "saldos", required = false)
    private Saldos saldos;
    @Element(name = "sitexp", required = false)
    private String sitexp;
    @Element(name = "situacion", required = false)
    private String situacion;
    @Element(name = "tamannoPagina", required = false)
    private int tamannoPagina;
    @Element(name = "totalPaginas", required = false)
    private int totalPaginas;
    @Element(name = "ultmov", required = false)
    private String ultmov;

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public void setExpanded(boolean expanded) {
        this.isExpanded = expanded;
    }

    public String getImpInterCostas() {
        return this.impInterCostas;
    }

    public void setImpInterCostas(String impInterCostas2) {
        this.impInterCostas = impInterCostas2;
    }

    public String getCodExpAlt() {
        return this.codExpAlt;
    }

    public void setCodExpAlt(String codExpAlt2) {
        this.codExpAlt = codExpAlt2;
    }

    public String getCodExpediente() {
        return this.codExpediente;
    }

    public void setCodExpediente(String codExpediente2) {
        this.codExpediente = codExpediente2;
    }

    public String getCodmon() {
        return this.codmon;
    }

    public void setCodmon(String codmon2) {
        this.codmon = codmon2;
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

    public String getProcedimiento() {
        return this.procedimiento;
    }

    public void setProcedimiento(String procedimiento2) {
        this.procedimiento = procedimiento2;
    }

    public Saldos getSaldos() {
        return this.saldos;
    }

    public void setSaldos(Saldos saldos2) {
        this.saldos = saldos2;
    }

    public String getSitexp() {
        return this.sitexp;
    }

    public void setSitexp(String sitexp2) {
        this.sitexp = sitexp2;
    }

    public String getSituacion() {
        return this.situacion;
    }

    public void setSituacion(String situacion2) {
        this.situacion = situacion2;
    }

    public String getUltmov() {
        return this.ultmov;
    }

    public void setUltmov(String ultmov2) {
        this.ultmov = ultmov2;
    }

    public int getNumerPagina() {
        return this.numerPagina;
    }

    public void setNumerPagina(int numerPagina2) {
        this.numerPagina = numerPagina2;
    }

    public int getTamannoPagina() {
        return this.tamannoPagina;
    }

    public void setTamannoPagina(int tamannoPagina2) {
        this.tamannoPagina = tamannoPagina2;
    }

    public int getTotalPaginas() {
        return this.totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas2) {
        this.totalPaginas = totalPaginas2;
    }

    public boolean isChild() {
        return this.isChild;
    }

    public void setChild(boolean child) {
        this.isChild = child;
    }

    public DetalleExpDatosExpDetail.DetalleExpSaldos getDetalleExpSaldos() {
        return this.detalleExpSaldos;
    }

    public void setDetalleExpSaldos(DetalleExpDatosExpDetail.DetalleExpSaldos detalleExpSaldos2) {
        this.detalleExpSaldos = detalleExpSaldos2;
    }

    public DatosExpedienteNew() {
    }

    public DatosExpedienteNew(DetalleExpDatosExpDetail.DetalleExpSaldos detalleExpSaldos2) {
        this.isChild = true;
        this.detalleExpSaldos = detalleExpSaldos2;
    }
}
