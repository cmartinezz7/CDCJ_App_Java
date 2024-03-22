package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FACTURA_PAGO_PRV_Type", propOrder = {"ordenpagopagoprv", "numfactura"})
public class FACTURAPAGOPRVType {
    @XmlElement(name = "NUM_FACTURA", required = true)
    protected String numfactura;
    @XmlElement(name = "ORDEN_PAGO_PAGO_PRV", required = true)
    protected ORDENPAGOPAGOPRVType ordenpagopagoprv;

    public ORDENPAGOPAGOPRVType getORDENPAGOPAGOPRV() {
        return this.ordenpagopagoprv;
    }

    public void setORDENPAGOPAGOPRV(ORDENPAGOPAGOPRVType oRDENPAGOPAGOPRVType) {
        this.ordenpagopagoprv = oRDENPAGOPAGOPRVType;
    }

    public String getNUMFACTURA() {
        return this.numfactura;
    }

    public void setNUMFACTURA(String str) {
        this.numfactura = str;
    }
}
