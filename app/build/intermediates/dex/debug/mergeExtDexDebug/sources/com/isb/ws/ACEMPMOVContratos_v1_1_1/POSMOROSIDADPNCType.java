package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POS_MOROSIDAD_PNC_Type", propOrder = {"empresa", "tipomovimiento", "tipomorosidad"})
public class POSMOROSIDADPNCType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_MOROSIDAD", required = true)
    protected String tipomorosidad;
    @XmlElement(name = "TIPO_MOVIMIENTO", required = true)
    protected String tipomovimiento;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPOMOVIMIENTO() {
        return this.tipomovimiento;
    }

    public void setTIPOMOVIMIENTO(String str) {
        this.tipomovimiento = str;
    }

    public String getTIPOMOROSIDAD() {
        return this.tipomorosidad;
    }

    public void setTIPOMOROSIDAD(String str) {
        this.tipomorosidad = str;
    }
}
