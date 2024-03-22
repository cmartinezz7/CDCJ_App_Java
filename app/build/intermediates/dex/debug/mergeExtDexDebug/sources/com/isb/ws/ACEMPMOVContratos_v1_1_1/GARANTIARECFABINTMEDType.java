package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GARANTIA_REC_FAB_INTMED_Type", propOrder = {"recibofabricaintmed", "idgarantiaintmed"})
public class GARANTIARECFABINTMEDType {
    @XmlElement(name = "ID_GARANTIA_INTMED", required = true)
    protected String idgarantiaintmed;
    @XmlElement(name = "RECIBO_FABRICA_INTMED", required = true)
    protected RECIBOFABRICAINTMEDType recibofabricaintmed;

    public RECIBOFABRICAINTMEDType getRECIBOFABRICAINTMED() {
        return this.recibofabricaintmed;
    }

    public void setRECIBOFABRICAINTMED(RECIBOFABRICAINTMEDType rECIBOFABRICAINTMEDType) {
        this.recibofabricaintmed = rECIBOFABRICAINTMEDType;
    }

    public String getIDGARANTIAINTMED() {
        return this.idgarantiaintmed;
    }

    public void setIDGARANTIAINTMED(String str) {
        this.idgarantiaintmed = str;
    }
}
