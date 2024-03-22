package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SIT_REC_DIST_INTMED_Type", propOrder = {"recibodistribintmed", "estadositrecintmed"})
public class SITRECDISTINTMEDType {
    @XmlElement(name = "ESTADO_SIT_REC_INTMED", required = true)
    protected String estadositrecintmed;
    @XmlElement(name = "RECIBO_DISTRIB_INTMED", required = true)
    protected RECIBODISTRIBINTMEDType recibodistribintmed;

    public RECIBODISTRIBINTMEDType getRECIBODISTRIBINTMED() {
        return this.recibodistribintmed;
    }

    public void setRECIBODISTRIBINTMED(RECIBODISTRIBINTMEDType rECIBODISTRIBINTMEDType) {
        this.recibodistribintmed = rECIBODISTRIBINTMEDType;
    }

    public String getESTADOSITRECINTMED() {
        return this.estadositrecintmed;
    }

    public void setESTADOSITRECINTMED(String str) {
        this.estadositrecintmed = str;
    }
}
