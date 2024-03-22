package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_GENERADOR_FLUJO_NOM_Type", propOrder = {"bmgsecurity", "idgenerador"})
public class BMGGENERADORFLUJONOMType {
    @XmlElement(name = "BMG_SECURITY", required = true)
    protected String bmgsecurity;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ID_GENERADOR")
    protected int idgenerador;

    public String getBMGSECURITY() {
        return this.bmgsecurity;
    }

    public void setBMGSECURITY(String str) {
        this.bmgsecurity = str;
    }

    public int getIDGENERADOR() {
        return this.idgenerador;
    }

    public void setIDGENERADOR(int i) {
        this.idgenerador = i;
    }
}
