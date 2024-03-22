package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_FLUJO_INTERES_Type", propOrder = {"bmgsecurity", "idinteres"})
public class BMGFLUJOINTERESType {
    @XmlElement(name = "BMG_SECURITY", required = true)
    protected String bmgsecurity;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ID_INTERES")
    protected int idinteres;

    public String getBMGSECURITY() {
        return this.bmgsecurity;
    }

    public void setBMGSECURITY(String str) {
        this.bmgsecurity = str;
    }

    public int getIDINTERES() {
        return this.idinteres;
    }

    public void setIDINTERES(int i) {
        this.idinteres = i;
    }
}
