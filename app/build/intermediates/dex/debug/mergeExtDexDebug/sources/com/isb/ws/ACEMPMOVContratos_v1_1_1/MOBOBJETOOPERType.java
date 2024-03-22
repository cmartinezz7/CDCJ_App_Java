package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOB_OBJETO_OPER_Type", propOrder = {"objetooperativo", "version"})
public class MOBOBJETOOPERType {
    @XmlElement(name = "OBJETO_OPERATIVO", required = true)
    protected String objetooperativo;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "VERSION")
    protected int version;

    public String getOBJETOOPERATIVO() {
        return this.objetooperativo;
    }

    public void setOBJETOOPERATIVO(String str) {
        this.objetooperativo = str;
    }

    public int getVERSION() {
        return this.version;
    }

    public void setVERSION(int i) {
        this.version = i;
    }
}
