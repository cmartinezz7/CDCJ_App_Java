package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_FLUJO_NOMINAL_Type", propOrder = {"bmgsecurity", "idoperaciones"})
public class BMGFLUJONOMINALType {
    @XmlElement(name = "BMG_SECURITY", required = true)
    protected String bmgsecurity;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ID_OPERACIONES")
    protected int idoperaciones;

    public String getBMGSECURITY() {
        return this.bmgsecurity;
    }

    public void setBMGSECURITY(String str) {
        this.bmgsecurity = str;
    }

    public int getIDOPERACIONES() {
        return this.idoperaciones;
    }

    public void setIDOPERACIONES(int i) {
        this.idoperaciones = i;
    }
}
