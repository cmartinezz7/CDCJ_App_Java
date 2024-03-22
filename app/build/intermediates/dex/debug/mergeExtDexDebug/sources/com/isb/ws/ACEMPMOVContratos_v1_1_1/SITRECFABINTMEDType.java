package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SIT_REC_FAB_INTMED_Type", propOrder = {"recibofabricaintmed", "estadositrecintmed"})
public class SITRECFABINTMEDType {
    @XmlElement(name = "ESTADO_SIT_REC_INTMED", required = true)
    protected String estadositrecintmed;
    @XmlElement(name = "RECIBO_FABRICA_INTMED", required = true)
    protected RECIBOFABRICAINTMEDType recibofabricaintmed;

    public RECIBOFABRICAINTMEDType getRECIBOFABRICAINTMED() {
        return this.recibofabricaintmed;
    }

    public void setRECIBOFABRICAINTMED(RECIBOFABRICAINTMEDType rECIBOFABRICAINTMEDType) {
        this.recibofabricaintmed = rECIBOFABRICAINTMEDType;
    }

    public String getESTADOSITRECINTMED() {
        return this.estadositrecintmed;
    }

    public void setESTADOSITRECINTMED(String str) {
        this.estadositrecintmed = str;
    }
}
