package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDENT_TAX_UNIT_PERSONA_Type", propOrder = {"empresa", "taxper", "tipodediscriminante"})
public class IDENTTAXUNITPERSONAType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TAXPER", required = true)
    protected String taxper;
    @XmlElement(name = "TIPO_DE_DISCRIMINANTE", required = true)
    protected String tipodediscriminante;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTAXPER() {
        return this.taxper;
    }

    public void setTAXPER(String str) {
        this.taxper = str;
    }

    public String getTIPODEDISCRIMINANTE() {
        return this.tipodediscriminante;
    }

    public void setTIPODEDISCRIMINANTE(String str) {
        this.tipodediscriminante = str;
    }
}
