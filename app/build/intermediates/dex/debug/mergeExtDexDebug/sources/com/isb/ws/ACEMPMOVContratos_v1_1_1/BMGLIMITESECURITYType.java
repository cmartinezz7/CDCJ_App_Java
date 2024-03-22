package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_LIMITE_SECURITY_Type", propOrder = {"bmgsecurity", "idlimite"})
public class BMGLIMITESECURITYType {
    @XmlElement(name = "BMG_SECURITY", required = true)
    protected String bmgsecurity;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ID_LIMITE")
    protected int idlimite;

    public String getBMGSECURITY() {
        return this.bmgsecurity;
    }

    public void setBMGSECURITY(String str) {
        this.bmgsecurity = str;
    }

    public int getIDLIMITE() {
        return this.idlimite;
    }

    public void setIDLIMITE(int i) {
        this.idlimite = i;
    }
}
