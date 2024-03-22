package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NIVEL_VISIBLE_RIESTC_Type", propOrder = {"empresa", "codnivelcartera", "codnivelvisible"})
public class NIVELVISIBLERIESTCType {
    @XmlElement(name = "COD_NIVEL_CARTERA", required = true)
    protected String codnivelcartera;
    @XmlElement(name = "COD_NIVEL_VISIBLE", required = true)
    protected String codnivelvisible;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODNIVELCARTERA() {
        return this.codnivelcartera;
    }

    public void setCODNIVELCARTERA(String str) {
        this.codnivelcartera = str;
    }

    public String getCODNIVELVISIBLE() {
        return this.codnivelvisible;
    }

    public void setCODNIVELVISIBLE(String str) {
        this.codnivelvisible = str;
    }
}
