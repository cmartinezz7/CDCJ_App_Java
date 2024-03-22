package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PROVEEDOR_PAGO_PRV_Type", propOrder = {"contrato", "codintproveedor"})
public class PROVEEDORPAGOPRVType {
    @XmlElement(name = "COD_INT_PROVEEDOR", required = true)
    protected String codintproveedor;
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public String getCODINTPROVEEDOR() {
        return this.codintproveedor;
    }

    public void setCODINTPROVEEDOR(String str) {
        this.codintproveedor = str;
    }
}
