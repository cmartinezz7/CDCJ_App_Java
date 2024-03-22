package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GARANTIA_REC_INTMED_Type", propOrder = {"recibointmed", "idgarantiaintmed"})
public class GARANTIARECINTMEDType {
    @XmlElement(name = "ID_GARANTIA_INTMED", required = true)
    protected String idgarantiaintmed;
    @XmlElement(name = "RECIBO_INTMED", required = true)
    protected String recibointmed;

    public String getRECIBOINTMED() {
        return this.recibointmed;
    }

    public void setRECIBOINTMED(String str) {
        this.recibointmed = str;
    }

    public String getIDGARANTIAINTMED() {
        return this.idgarantiaintmed;
    }

    public void setIDGARANTIAINTMED(String str) {
        this.idgarantiaintmed = str;
    }
}
