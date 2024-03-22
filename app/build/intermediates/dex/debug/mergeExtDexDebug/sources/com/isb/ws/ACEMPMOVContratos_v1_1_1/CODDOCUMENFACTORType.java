package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COD_DOCUMEN_FACTOR_Type", propOrder = {"empresa", "tipodocumentofactor", "coddocumentofactor"})
public class CODDOCUMENFACTORType {
    @XmlElement(name = "COD_DOCUMENTO_FACTOR", required = true)
    protected String coddocumentofactor;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_DOCUMENTO_FACTOR", required = true)
    protected String tipodocumentofactor;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPODOCUMENTOFACTOR() {
        return this.tipodocumentofactor;
    }

    public void setTIPODOCUMENTOFACTOR(String str) {
        this.tipodocumentofactor = str;
    }

    public String getCODDOCUMENTOFACTOR() {
        return this.coddocumentofactor;
    }

    public void setCODDOCUMENTOFACTOR(String str) {
        this.coddocumentofactor = str;
    }
}
