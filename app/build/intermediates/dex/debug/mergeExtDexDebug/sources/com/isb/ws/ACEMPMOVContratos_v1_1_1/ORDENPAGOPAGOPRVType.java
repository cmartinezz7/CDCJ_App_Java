package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORDEN_PAGO_PAGO_PRV_Type", propOrder = {"remesa", "numordenpago"})
public class ORDENPAGOPAGOPRVType {
    @XmlElement(name = "NUM_ORDEN_PAGO", required = true)
    protected String numordenpago;
    @XmlElement(name = "REMESA", required = true)
    protected REMESAPAGOPRVType remesa;

    public REMESAPAGOPRVType getREMESA() {
        return this.remesa;
    }

    public void setREMESA(REMESAPAGOPRVType rEMESAPAGOPRVType) {
        this.remesa = rEMESAPAGOPRVType;
    }

    public String getNUMORDENPAGO() {
        return this.numordenpago;
    }

    public void setNUMORDENPAGO(String str) {
        this.numordenpago = str;
    }
}
