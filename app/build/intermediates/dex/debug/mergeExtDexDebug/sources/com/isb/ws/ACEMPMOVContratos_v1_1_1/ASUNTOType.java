package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ASUNTO_Type", propOrder = {"empresa", "codasunto"})
public class ASUNTOType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_ASUNTO")
    protected int codasunto;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODASUNTO() {
        return this.codasunto;
    }

    public void setCODASUNTO(int i) {
        this.codasunto = i;
    }
}
