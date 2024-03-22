package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RECIBO_FABRICA_INTMED_Type", propOrder = {"idfabricaintmed", "numrecibofabintmed"})
public class RECIBOFABRICAINTMEDType {
    @XmlElement(name = "ID_FABRICA_INTMED", required = true)
    protected String idfabricaintmed;
    @XmlElement(name = "NUM_RECIBO_FAB_INTMED", required = true)
    protected String numrecibofabintmed;

    public String getIDFABRICAINTMED() {
        return this.idfabricaintmed;
    }

    public void setIDFABRICAINTMED(String str) {
        this.idfabricaintmed = str;
    }

    public String getNUMRECIBOFABINTMED() {
        return this.numrecibofabintmed;
    }

    public void setNUMRECIBOFABINTMED(String str) {
        this.numrecibofabintmed = str;
    }
}
