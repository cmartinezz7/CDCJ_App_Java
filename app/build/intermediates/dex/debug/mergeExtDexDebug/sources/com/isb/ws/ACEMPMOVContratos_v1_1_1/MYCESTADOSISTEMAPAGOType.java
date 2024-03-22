package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MYC_ESTADO_SISTEMA_PAGO_Type", propOrder = {"mycestadoprocesopago", "codestsistema"})
public class MYCESTADOSISTEMAPAGOType {
    @XmlElement(name = "COD_EST_SISTEMA", required = true)
    protected String codestsistema;
    @XmlElement(name = "MYC_ESTADO_PROCESO_PAGO", required = true)
    protected MYCESTADOPROCESOPAGOType mycestadoprocesopago;

    public MYCESTADOPROCESOPAGOType getMYCESTADOPROCESOPAGO() {
        return this.mycestadoprocesopago;
    }

    public void setMYCESTADOPROCESOPAGO(MYCESTADOPROCESOPAGOType mYCESTADOPROCESOPAGOType) {
        this.mycestadoprocesopago = mYCESTADOPROCESOPAGOType;
    }

    public String getCODESTSISTEMA() {
        return this.codestsistema;
    }

    public void setCODESTSISTEMA(String str) {
        this.codestsistema = str;
    }
}
