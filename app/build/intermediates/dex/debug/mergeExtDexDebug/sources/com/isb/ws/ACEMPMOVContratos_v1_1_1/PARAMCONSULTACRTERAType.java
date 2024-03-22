package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PARAM_CONSULTA_CRTERA_Type", propOrder = {"idparam", "codparam"})
public class PARAMCONSULTACRTERAType {
    @XmlElement(name = "COD_PARAM", required = true)
    protected String codparam;
    @XmlElement(name = "ID_PARAM", required = true)
    protected String idparam;

    public String getIDPARAM() {
        return this.idparam;
    }

    public void setIDPARAM(String str) {
        this.idparam = str;
    }

    public String getCODPARAM() {
        return this.codparam;
    }

    public void setCODPARAM(String str) {
        this.codparam = str;
    }
}
