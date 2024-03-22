package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHEQUE_LOCAL_Type", propOrder = {"tipochequelocal", "chequetransito"})
public class CHEQUELOCALType {
    @XmlElement(name = "CHEQUE_TRANSITO", required = true)
    protected String chequetransito;
    @XmlElement(name = "TIPO_CHEQUE_LOCAL", required = true)
    protected String tipochequelocal;

    public String getTIPOCHEQUELOCAL() {
        return this.tipochequelocal;
    }

    public void setTIPOCHEQUELOCAL(String str) {
        this.tipochequelocal = str;
    }

    public String getCHEQUETRANSITO() {
        return this.chequetransito;
    }

    public void setCHEQUETRANSITO(String str) {
        this.chequetransito = str;
    }
}
