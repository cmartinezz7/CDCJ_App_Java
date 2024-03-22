package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GCPB_PREGUNTAPBC_Type", propOrder = {"pregpbc", "sisdatpbc"})
public class GCPBPREGUNTAPBCType {
    @XmlElement(name = "PREG_PBC", required = true)
    protected String pregpbc;
    @XmlElement(name = "SISDAT_PBC", required = true)
    protected String sisdatpbc;

    public String getPREGPBC() {
        return this.pregpbc;
    }

    public void setPREGPBC(String str) {
        this.pregpbc = str;
    }

    public String getSISDATPBC() {
        return this.sisdatpbc;
    }

    public void setSISDATPBC(String str) {
        this.sisdatpbc = str;
    }
}
