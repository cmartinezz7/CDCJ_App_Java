package es.santander.justicia.minisJusticia.models.responses.consultaOperaciones;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "return", strict = false)
public class ConsultaOperaciones {
    @Element(name = "anyoApertura", required = false)
    private String anyoApertura;
    @Element(name = "cdconc", required = false)
    private String cdconc;
    @Element(name = "codTipoMovimiento", required = false)
    private String codTipoMovimiento;
    @Element(name = "codTipoOperacion", required = false)
    private String codTipoOperacion;
    @Element(name = "codigoEstadoOperacion", required = false)
    private String codigoEstadoOperacion;
    @Element(name = "codigoMoneda", required = false)
    private String codigoMoneda;
    @Element(name = "codmon", required = false)
    private String codmon;
    @Element(name = "conc30", required = false)
    private String conc30;
    @Element(name = "desctipomod", required = false)
    private String desctipomod;
    @Element(name = "fechaAltaOperacion", required = false)
    private String fechaAltaOperacion;
    @Element(name = "fechaCaducidad", required = false)
    private String fechaCaducidad;
    @Element(name = "fechaUltimaModificacionEstado", required = false)
    private String fechaUltimaModificacionEstado;
    @Element(name = "importe", required = false)
    private String importe;
    @Element(name = "indres", required = false)
    private String indres;
    @Element(name = "jcodpais", required = false)
    private String jcodpais;
    @Element(name = "jfeccaduc", required = false)
    private String jfeccaduc;
    @Element(name = "jfechare", required = false)
    private String jfechare;
    @Element(name = "jimpnomi", required = false)
    private String jimpnomi;
    @Element(name = "jnors", required = false)
    private String jnors;
    @Element(name = "jnuoper", required = false)
    private String jnuoper;
    @Element(name = "jtipopera", required = false)
    private String jtipopera;
    @Element(name = "jusrhare", required = false)
    private String jusrhare;
    @Element(name = "juzgadoDestino", required = false)
    private String juzgadoDestino;
    @Element(name = "juzgadoOrigen", required = false)
    private String juzgadoOrigen;
    @Element(name = "moneda", required = false)
    private String moneda;
    @Element(name = "numExpediente", required = false)
    private String numExpediente;
    @Element(name = "numMandamiento", required = false)
    private String numMandamiento;
    @Element(name = "numOperacion", required = false)
    private String numOperacion;
    @Element(name = "numeroPagina", required = false)
    private int numerPagina;
    @Element(name = "numerosr", required = false)
    private String numerosr;
    @Element(name = "pais", required = false)
    private String pais;
    @Element(name = "procedimiento", required = false)
    private String procedimiento;
    @Element(name = "seralfab", required = false)
    private String seralfab;
    @Element(name = "serieYMandamiento", required = false)
    private String serieYMandamiento;
    @Element(name = "tamannoPagina", required = false)
    private int tamannoPagina;
    @Element(name = "tipoMoneda", required = false)
    private String tipoMoneda;
    @Element(name = "tipoOperacion", required = false)
    private String tipoOperacion;
    @Element(name = "titular", required = false)
    private String titular;
    @Element(name = "totalPaginas", required = false)
    private int totalPaginas;

    public int getNumerPagina() {
        return this.numerPagina;
    }

    public int getTamannoPagina() {
        return this.tamannoPagina;
    }

    public int getTotalPaginas() {
        return this.totalPaginas;
    }

    public String getAnyoApertura() {
        return this.anyoApertura;
    }

    public String getCodTipoMovimiento() {
        return this.codTipoMovimiento;
    }

    public String getCodTipoOperacion() {
        return this.codTipoOperacion;
    }

    public String getCodigoEstadoOperacion() {
        return this.codigoEstadoOperacion;
    }

    public String getCodigoMoneda() {
        return this.codigoMoneda;
    }

    public String getFechaAltaOperacion() {
        return this.fechaAltaOperacion;
    }

    public String getFechaCaducidad() {
        return this.fechaCaducidad;
    }

    public String getFechaUltimaModificacionEstado() {
        return this.fechaUltimaModificacionEstado;
    }

    public String getImporte() {
        return this.importe;
    }

    public String getJuzgadoDestino() {
        return this.juzgadoDestino;
    }

    public String getJuzgadoOrigen() {
        return this.juzgadoOrigen;
    }

    public String getNumExpediente() {
        return this.numExpediente;
    }

    public String getNumMandamiento() {
        return this.numMandamiento;
    }

    public String getNumOperacion() {
        return this.numOperacion;
    }

    public String getProcedimiento() {
        return this.procedimiento;
    }

    public String getTipoMoneda() {
        return this.tipoMoneda;
    }

    public String getTipoOperacion() {
        return this.tipoOperacion;
    }

    public String getTitular() {
        return this.titular;
    }

    public String getCdconc() {
        return this.cdconc;
    }

    public String getCodmon() {
        return this.codmon;
    }

    public String getConc30() {
        return this.conc30;
    }

    public String getDesctipomod() {
        return this.desctipomod;
    }

    public String getIndres() {
        return this.indres;
    }

    public String getJcodpais() {
        return this.jcodpais;
    }

    public String getJfeccaduc() {
        return this.jfeccaduc;
    }

    public String getJfechare() {
        return this.jfechare;
    }

    public String getJimpnomi() {
        return this.jimpnomi;
    }

    public String getJnors() {
        return this.jnors;
    }

    public String getJnuoper() {
        return this.jnuoper;
    }

    public String getJtipopera() {
        return this.jtipopera;
    }

    public String getJusrhare() {
        return this.jusrhare;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public String getNumerosr() {
        return this.numerosr;
    }

    public String getPais() {
        return this.pais;
    }

    public String getSeralfab() {
        return this.seralfab;
    }

    public String getSerieYMandamiento() {
        return this.serieYMandamiento;
    }
}
