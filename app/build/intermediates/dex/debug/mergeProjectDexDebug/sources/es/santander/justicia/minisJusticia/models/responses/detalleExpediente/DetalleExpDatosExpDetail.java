package es.santander.justicia.minisJusticia.models.responses.detalleExpediente;

import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DetalleExpDatosExpDetail {
    @Element(name = "codExpAlt", required = false)
    private String codExpAlt;
    @Element(name = "codExpediente", required = false)
    private String codExpediente;
    @Element(name = "codmon", required = false)
    private String codmon;
    @Element(name = "codprior", required = false)
    private String codprior;
    @Element(name = "impInterCostas", required = false)
    private String impInterCostas;
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
    @Element(name = "primov", required = false)
    private String primov;
    @Element(name = "prioridad", required = false)
    private String prioridad;
    @Element(name = "procedimiento", required = false)
    private String procedimiento;
    @ElementList(inline = true, required = false)
    private ArrayList<DetalleExpSaldos> saldos = new ArrayList<>();
    @Element(name = "sitexp", required = false)
    private String sitexp;
    @Element(name = "situacion", required = false)
    private String situacion;
    @Element(name = "ultmov", required = false)
    private String ultmov;

    @Root(name = "saldos", strict = false)
    public static class DetalleExpSaldos {
        @Element(name = "codmon", required = false)
        private String codmon;
        @Element(name = "ingpendconso", required = false)
        private String ingpendconso;
        @Element(name = "moneda", required = false)
        private String moneda;
        @Element(name = "pagopendconf", required = false)
        private String pagopendconf;
        @Element(name = "pagopendconso", required = false)
        private String pagopendconso;
        @Element(name = "principal", required = false)
        private String principal;
        @Element(name = "saldoconso", required = false)
        private String saldoconso;
        @Element(name = "saldodia", required = false)
        private String saldodia;
        @Element(name = "saldodisp", required = false)
        private String saldodisp;
        @Element(name = "saldoingdeposito", required = false)
        private String saldoingdeposito;
        @Element(name = "saldoingerroneo", required = false)
        private String saldoingerroneo;

        public String getPrincipal() {
            return this.principal;
        }

        public void setPrincipal(String principal2) {
            this.principal = principal2;
        }

        public String getCodmon() {
            return this.codmon;
        }

        public String getIngpendconso() {
            return this.ingpendconso;
        }

        public String getMoneda() {
            return this.moneda;
        }

        public String getPagopendconf() {
            return this.pagopendconf;
        }

        public String getPagopendconso() {
            return this.pagopendconso;
        }

        public String getSaldoconso() {
            return this.saldoconso;
        }

        public String getSaldodia() {
            return this.saldodia;
        }

        public String getSaldodisp() {
            return this.saldodisp;
        }

        public String getSaldoingdeposito() {
            return this.saldoingdeposito;
        }

        public String getSaldoingerroneo() {
            return this.saldoingerroneo;
        }

        public void setIngpendconso(String ingpendconso2) {
            this.ingpendconso = ingpendconso2;
        }

        public void setPagopendconf(String pagopendconf2) {
            this.pagopendconf = pagopendconf2;
        }

        public void setPagopendconso(String pagopendconso2) {
            this.pagopendconso = pagopendconso2;
        }

        public void setSaldoconso(String saldoconso2) {
            this.saldoconso = saldoconso2;
        }

        public void setSaldodia(String saldodia2) {
            this.saldodia = saldodia2;
        }

        public void setSaldodisp(String saldodisp2) {
            this.saldodisp = saldodisp2;
        }

        public void setSaldoingdeposito(String saldoingdeposito2) {
            this.saldoingdeposito = saldoingdeposito2;
        }

        public void setSaldoingerroneo(String saldoingerroneo2) {
            this.saldoingerroneo = saldoingerroneo2;
        }
    }

    public ArrayList<DetalleExpSaldos> getSaldos() {
        return this.saldos;
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

    public String getCodprior() {
        return this.codprior;
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

    public String getPrioridad() {
        return this.prioridad;
    }

    public String getProcedimiento() {
        return this.procedimiento;
    }

    public String getSitexp() {
        return this.sitexp;
    }

    public String getSituacion() {
        return this.situacion;
    }

    public String getImpInterCostas() {
        return this.impInterCostas;
    }

    public String getUltmov() {
        return this.ultmov;
    }
}
