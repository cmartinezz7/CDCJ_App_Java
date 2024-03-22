package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBSISTEMA_GSTP_Type", propOrder = {"sistemagstp", "codsubsistemagstp"})
public class SUBSISTEMAGSTPType {
    @XmlElement(name = "COD_SUBSISTEMA_GSTP", required = true)
    protected String codsubsistemagstp;
    @XmlElement(name = "SISTEMA_GSTP", required = true)
    protected String sistemagstp;

    public String getSISTEMAGSTP() {
        return this.sistemagstp;
    }

    public void setSISTEMAGSTP(String str) {
        this.sistemagstp = str;
    }

    public String getCODSUBSISTEMAGSTP() {
        return this.codsubsistemagstp;
    }

    public void setCODSUBSISTEMAGSTP(String str) {
        this.codsubsistemagstp = str;
    }
}
