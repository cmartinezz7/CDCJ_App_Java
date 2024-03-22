package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_GENERADOR_FLUJO_INTER_Type", propOrder = {"bmgsecurity", "codgenerador"})
public class BMGGENERADORFLUJOINTERType {
    @XmlElement(name = "BMG_SECURITY", required = true)
    protected String bmgsecurity;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_GENERADOR")
    protected int codgenerador;

    public String getBMGSECURITY() {
        return this.bmgsecurity;
    }

    public void setBMGSECURITY(String str) {
        this.bmgsecurity = str;
    }

    public int getCODGENERADOR() {
        return this.codgenerador;
    }

    public void setCODGENERADOR(int i) {
        this.codgenerador = i;
    }
}
