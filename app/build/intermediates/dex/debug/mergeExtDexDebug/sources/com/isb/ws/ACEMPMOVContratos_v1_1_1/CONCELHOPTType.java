package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONCELHO_PT_Type", propOrder = {"distritopt", "codconcelho"})
public class CONCELHOPTType {
    @XmlElement(name = "COD_CONCELHO", required = true)
    protected String codconcelho;
    @XmlElement(name = "DISTRITO_PT", required = true)
    protected String distritopt;

    public String getDISTRITOPT() {
        return this.distritopt;
    }

    public void setDISTRITOPT(String str) {
        this.distritopt = str;
    }

    public String getCODCONCELHO() {
        return this.codconcelho;
    }

    public void setCODCONCELHO(String str) {
        this.codconcelho = str;
    }
}
