package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REF_POL_PAGOS_GAU_Type", propOrder = {"empresa", "referenciapoliticapagos", "moneda"})
public class REFPOLPAGOSGAUType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "MONEDA", required = true)
    protected String moneda;
    @XmlElement(name = "REFERENCIA_POLITICA_PAGOS", required = true)
    protected String referenciapoliticapagos;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getREFERENCIAPOLITICAPAGOS() {
        return this.referenciapoliticapagos;
    }

    public void setREFERENCIAPOLITICAPAGOS(String str) {
        this.referenciapoliticapagos = str;
    }

    public String getMONEDA() {
        return this.moneda;
    }

    public void setMONEDA(String str) {
        this.moneda = str;
    }
}
