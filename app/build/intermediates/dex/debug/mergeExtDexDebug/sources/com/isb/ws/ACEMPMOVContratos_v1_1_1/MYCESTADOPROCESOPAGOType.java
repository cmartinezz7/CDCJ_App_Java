package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MYC_ESTADO_PROCESO_PAGO_Type", propOrder = {"codestproceso", "codproducto", "codproceso", "codsistema"})
public class MYCESTADOPROCESOPAGOType {
    @XmlElement(name = "COD_EST_PROCESO", required = true)
    protected String codestproceso;
    @XmlElement(name = "COD_PROCESO", required = true)
    protected String codproceso;
    @XmlElement(name = "COD_PRODUCTO", required = true)
    protected String codproducto;
    @XmlElement(name = "COD_SISTEMA", required = true)
    protected String codsistema;

    public String getCODESTPROCESO() {
        return this.codestproceso;
    }

    public void setCODESTPROCESO(String str) {
        this.codestproceso = str;
    }

    public String getCODPRODUCTO() {
        return this.codproducto;
    }

    public void setCODPRODUCTO(String str) {
        this.codproducto = str;
    }

    public String getCODPROCESO() {
        return this.codproceso;
    }

    public void setCODPROCESO(String str) {
        this.codproceso = str;
    }

    public String getCODSISTEMA() {
        return this.codsistema;
    }

    public void setCODSISTEMA(String str) {
        this.codsistema = str;
    }
}
