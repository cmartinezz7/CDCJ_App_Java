package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_MENSAJE_Type", propOrder = {"ambito", "codtipomensaje"})
public class TIPOMENSAJEType {
    @XmlElement(name = "AMBITO", required = true)
    protected String ambito;
    @XmlElement(name = "COD_TIPO_MENSAJE", required = true)
    protected String codtipomensaje;

    public String getAMBITO() {
        return this.ambito;
    }

    public void setAMBITO(String str) {
        this.ambito = str;
    }

    public String getCODTIPOMENSAJE() {
        return this.codtipomensaje;
    }

    public void setCODTIPOMENSAJE(String str) {
        this.codtipomensaje = str;
    }
}
