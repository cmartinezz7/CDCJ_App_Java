package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NUM_PERSONA_EQUIPARADA_Type", propOrder = {"tipopersona", "codigodepersona"})
public class NUMPERSONAEQUIPARADAType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_DE_PERSONA")
    protected int codigodepersona;
    @XmlElement(name = "TIPO_PERSONA", required = true)
    protected String tipopersona;

    public String getTIPOPERSONA() {
        return this.tipopersona;
    }

    public void setTIPOPERSONA(String str) {
        this.tipopersona = str;
    }

    public int getCODIGODEPERSONA() {
        return this.codigodepersona;
    }

    public void setCODIGODEPERSONA(int i) {
        this.codigodepersona = i;
    }
}
