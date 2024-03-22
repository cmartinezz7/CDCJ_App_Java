package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GCPB_EXPED_Type", propOrder = {"empresa", "canal", "codexpedpbc"})
public class GCPBEXPEDType {
    @XmlElement(name = "CANAL", required = true)
    protected String canal;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODEXPED_PBC")
    protected int codexpedpbc;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCANAL() {
        return this.canal;
    }

    public void setCANAL(String str) {
        this.canal = str;
    }

    public int getCODEXPEDPBC() {
        return this.codexpedpbc;
    }

    public void setCODEXPEDPBC(int i) {
        this.codexpedpbc = i;
    }
}
