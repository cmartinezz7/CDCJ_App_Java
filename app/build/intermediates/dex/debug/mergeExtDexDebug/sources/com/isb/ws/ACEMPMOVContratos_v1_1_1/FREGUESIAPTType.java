package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FREGUESIA_PT_Type", propOrder = {"concelhopt", "codfreguesia"})
public class FREGUESIAPTType {
    @XmlElement(name = "COD_FREGUESIA", required = true)
    protected String codfreguesia;
    @XmlElement(name = "CONCELHO_PT", required = true)
    protected CONCELHOPTType concelhopt;

    public CONCELHOPTType getCONCELHOPT() {
        return this.concelhopt;
    }

    public void setCONCELHOPT(CONCELHOPTType cONCELHOPTType) {
        this.concelhopt = cONCELHOPTType;
    }

    public String getCODFREGUESIA() {
        return this.codfreguesia;
    }

    public void setCODFREGUESIA(String str) {
        this.codfreguesia = str;
    }
}
