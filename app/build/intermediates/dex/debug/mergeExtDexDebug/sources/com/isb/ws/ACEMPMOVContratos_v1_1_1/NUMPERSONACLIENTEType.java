package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NUM_PERSONA_CLIENTE_Type", propOrder = {"tipodepersona", "codigodepersona"})
public class NUMPERSONACLIENTEType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_DE_PERSONA")
    protected int codigodepersona;
    @XmlElement(name = "TIPO_DE_PERSONA", required = true)
    protected String tipodepersona;

    public String getTIPODEPERSONA() {
        return this.tipodepersona;
    }

    public void setTIPODEPERSONA(String str) {
        this.tipodepersona = str;
    }

    public int getCODIGODEPERSONA() {
        return this.codigodepersona;
    }

    public void setCODIGODEPERSONA(int i) {
        this.codigodepersona = i;
    }
}
