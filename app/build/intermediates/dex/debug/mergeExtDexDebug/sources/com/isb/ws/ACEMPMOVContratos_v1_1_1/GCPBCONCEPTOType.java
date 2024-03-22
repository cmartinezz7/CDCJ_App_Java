package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GCPB_CONCEPTO_Type", propOrder = {"codconpbc", "codvalpbc"})
public class GCPBCONCEPTOType {
    @XmlElement(name = "CODCON_PBC", required = true)
    protected String codconpbc;
    @XmlElement(name = "CODVAL_PBC", required = true)
    protected String codvalpbc;

    public String getCODCONPBC() {
        return this.codconpbc;
    }

    public void setCODCONPBC(String str) {
        this.codconpbc = str;
    }

    public String getCODVALPBC() {
        return this.codvalpbc;
    }

    public void setCODVALPBC(String str) {
        this.codvalpbc = str;
    }
}
