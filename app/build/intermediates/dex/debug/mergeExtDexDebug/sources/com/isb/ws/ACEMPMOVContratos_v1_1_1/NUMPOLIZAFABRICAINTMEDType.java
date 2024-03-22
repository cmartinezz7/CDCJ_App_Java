package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NUM_POLIZA_FABRICA_INTMED_Type", propOrder = {"idfabricaintmed", "numeropolizafabrica"})
public class NUMPOLIZAFABRICAINTMEDType {
    @XmlElement(name = "ID_FABRICA_INTMED", required = true)
    protected String idfabricaintmed;
    @XmlElement(name = "NUMERO_POLIZA_FABRICA", required = true)
    protected String numeropolizafabrica;

    public String getIDFABRICAINTMED() {
        return this.idfabricaintmed;
    }

    public void setIDFABRICAINTMED(String str) {
        this.idfabricaintmed = str;
    }

    public String getNUMEROPOLIZAFABRICA() {
        return this.numeropolizafabrica;
    }

    public void setNUMEROPOLIZAFABRICA(String str) {
        this.numeropolizafabrica = str;
    }
}
