package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FORMATO_SCC_Type", propOrder = {"empresa", "codigodeformato"})
public class FORMATOSCCType {
    @XmlElement(name = "CODIGO_DE_FORMATO", required = true)
    protected String codigodeformato;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODIGODEFORMATO() {
        return this.codigodeformato;
    }

    public void setCODIGODEFORMATO(String str) {
        this.codigodeformato = str;
    }
}
