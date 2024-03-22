package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RECIBO_DISTRIB_INTMED_Type", propOrder = {"iddistribuidorintmed", "numrecibodistintmed"})
public class RECIBODISTRIBINTMEDType {
    @XmlElement(name = "ID_DISTRIBUIDOR_INTMED", required = true)
    protected String iddistribuidorintmed;
    @XmlElement(name = "NUM_RECIBO_DIST_INTMED", required = true)
    protected String numrecibodistintmed;

    public String getIDDISTRIBUIDORINTMED() {
        return this.iddistribuidorintmed;
    }

    public void setIDDISTRIBUIDORINTMED(String str) {
        this.iddistribuidorintmed = str;
    }

    public String getNUMRECIBODISTINTMED() {
        return this.numrecibodistintmed;
    }

    public void setNUMRECIBODISTINTMED(String str) {
        this.numrecibodistintmed = str;
    }
}
