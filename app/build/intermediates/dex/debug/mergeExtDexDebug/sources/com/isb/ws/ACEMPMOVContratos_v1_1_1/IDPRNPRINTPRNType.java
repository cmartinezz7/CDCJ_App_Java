package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_PRN_PRINT_PRN_Type", propOrder = {"empresa", "docprpnt"})
public class IDPRNPRINTPRNType {
    @XmlElement(name = "DOCPRPNT", required = true)
    protected String docprpnt;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getDOCPRPNT() {
        return this.docprpnt;
    }

    public void setDOCPRPNT(String str) {
        this.docprpnt = str;
    }
}
