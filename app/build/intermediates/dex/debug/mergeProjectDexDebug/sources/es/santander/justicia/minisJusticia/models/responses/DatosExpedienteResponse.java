package es.santander.justicia.minisJusticia.models.responses;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import es.santander.justicia.minisJusticia.models.responses.buscarExpedientes.Saldos;
import es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DatosExpedienteResponse implements Parent<DetalleExpDatosExpDetail.DetalleExpSaldos> {
    private List<DetalleExpDatosExpDetail.DetalleExpSaldos> childList;
    @Element(name = "codExpAlt", required = false)
    private String codExpAlt;
    @Element(name = "codExpediente", required = false)
    private String codExpediente;
    @Element(name = "codmon", required = false)
    private String codmon;
    @Element(name = "impInterCostas", required = false)
    private String impCostas;
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

    public void setChildList(ArrayList<DetalleExpDatosExpDetail.DetalleExpSaldos> childList2) {
        if (childList2 != null) {
            this.childList = childList2;
        }
    }

    public DatosExpedienteResponse() {
        ArrayList arrayList = new ArrayList();
        this.childList = arrayList;
        arrayList.add(new DetalleExpDatosExpDetail.DetalleExpSaldos());
    }

    public String getImpCostas() {
        return this.impCostas;
    }

    public String getCodExpAlt() {
        return this.codExpAlt;
    }

    public String getCodExpediente() {
        return this.codExpediente;
    }

    public String getCodmon() {
        return this.codmon;
    }

    public String getJanoapex() {
        return this.janoapex;
    }

    public String getJnumexp() {
        return this.jnumexp;
    }

    public String getJproced() {
        return this.jproced;
    }

    public String getJuzga() {
        return this.juzga;
    }

    public String getJuzgori() {
        return this.juzgori;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public String getPrimov() {
        return this.primov;
    }

    public String getProcedimiento() {
        return this.procedimiento;
    }

    public Saldos getSaldos() {
        return this.saldos;
    }

    public String getSitexp() {
        return this.sitexp;
    }

    public String getSituacion() {
        return this.situacion;
    }

    public String getUltmov() {
        return this.ultmov;
    }

    public int getNumerPagina() {
        return this.numerPagina;
    }

    public int getTamannoPagina() {
        return this.tamannoPagina;
    }

    public int getTotalPaginas() {
        return this.totalPaginas;
    }

    public List<DetalleExpDatosExpDetail.DetalleExpSaldos> getChildList() {
        List<DetalleExpDatosExpDetail.DetalleExpSaldos> list = this.childList;
        if (list == null) {
            return new ArrayList();
        }
        return list;
    }

    public List<DetalleExpDatosExpDetail.DetalleExpSaldos> getOriginalChildList() {
        return this.childList;
    }

    public boolean isInitiallyExpanded() {
        return false;
    }
}
