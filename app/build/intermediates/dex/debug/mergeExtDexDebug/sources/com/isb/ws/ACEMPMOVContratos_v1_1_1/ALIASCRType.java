package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ALIAS_CR_Type", propOrder = {"empresa", "sistema", "conceptonegocio", "codalias"})
public class ALIASCRType {
    @XmlElement(name = "COD_ALIAS", required = true)
    protected String codalias;
    @XmlElement(name = "CONCEPTO_NEGOCIO", required = true)
    protected String conceptonegocio;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "SISTEMA", required = true)
    protected String sistema;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getSISTEMA() {
        return this.sistema;
    }

    public void setSISTEMA(String str) {
        this.sistema = str;
    }

    public String getCONCEPTONEGOCIO() {
        return this.conceptonegocio;
    }

    public void setCONCEPTONEGOCIO(String str) {
        this.conceptonegocio = str;
    }

    public String getCODALIAS() {
        return this.codalias;
    }

    public void setCODALIAS(String str) {
        this.codalias = str;
    }
}
