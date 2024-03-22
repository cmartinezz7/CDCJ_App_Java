package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ANTICIPO_PAGO_PRV_Type", propOrder = {"contratoanticipo", "numsecpago"})
public class ANTICIPOPAGOPRVType {
    @XmlElement(name = "CONTRATO_ANTICIPO", required = true)
    protected CONTRATOType contratoanticipo;
    @XmlElement(name = "NUM_SEC_PAGO", required = true)
    protected String numsecpago;

    public CONTRATOType getCONTRATOANTICIPO() {
        return this.contratoanticipo;
    }

    public void setCONTRATOANTICIPO(CONTRATOType cONTRATOType) {
        this.contratoanticipo = cONTRATOType;
    }

    public String getNUMSECPAGO() {
        return this.numsecpago;
    }

    public void setNUMSECPAGO(String str) {
        this.numsecpago = str;
    }
}
