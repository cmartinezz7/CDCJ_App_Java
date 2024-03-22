package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GARANTIA_REC_DIST_INTMED_Type", propOrder = {"recibodistribintmed", "idgarantiaintmed"})
public class GARANTIARECDISTINTMEDType {
    @XmlElement(name = "ID_GARANTIA_INTMED", required = true)
    protected String idgarantiaintmed;
    @XmlElement(name = "RECIBO_DISTRIB_INTMED", required = true)
    protected RECIBODISTRIBINTMEDType recibodistribintmed;

    public RECIBODISTRIBINTMEDType getRECIBODISTRIBINTMED() {
        return this.recibodistribintmed;
    }

    public void setRECIBODISTRIBINTMED(RECIBODISTRIBINTMEDType rECIBODISTRIBINTMEDType) {
        this.recibodistribintmed = rECIBODISTRIBINTMEDType;
    }

    public String getIDGARANTIAINTMED() {
        return this.idgarantiaintmed;
    }

    public void setIDGARANTIAINTMED(String str) {
        this.idgarantiaintmed = str;
    }
}
