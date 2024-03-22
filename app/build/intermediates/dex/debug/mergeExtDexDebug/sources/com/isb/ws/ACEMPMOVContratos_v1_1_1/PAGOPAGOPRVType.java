package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PAGO_PAGO_PRV_Type", propOrder = {"ordenpagopagoprv", "numpago"})
public class PAGOPAGOPRVType {
    @XmlElement(name = "NUM_PAGO", required = true)
    protected String numpago;
    @XmlElement(name = "ORDEN_PAGO_PAGO_PRV", required = true)
    protected ORDENPAGOPAGOPRVType ordenpagopagoprv;

    public ORDENPAGOPAGOPRVType getORDENPAGOPAGOPRV() {
        return this.ordenpagopagoprv;
    }

    public void setORDENPAGOPAGOPRV(ORDENPAGOPAGOPRVType oRDENPAGOPAGOPRVType) {
        this.ordenpagopagoprv = oRDENPAGOPAGOPRVType;
    }

    public String getNUMPAGO() {
        return this.numpago;
    }

    public void setNUMPAGO(String str) {
        this.numpago = str;
    }
}
