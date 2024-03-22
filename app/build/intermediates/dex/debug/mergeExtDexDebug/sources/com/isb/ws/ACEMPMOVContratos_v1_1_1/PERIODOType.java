package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PERIODO_Type", propOrder = {"unidaddetiempo", "numerodeunidades"})
public class PERIODOType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUMERO_DE_UNIDADES")
    protected int numerodeunidades;
    @XmlElement(name = "UNIDAD_DE_TIEMPO", required = true)
    protected String unidaddetiempo;

    public String getUNIDADDETIEMPO() {
        return this.unidaddetiempo;
    }

    public void setUNIDADDETIEMPO(String str) {
        this.unidaddetiempo = str;
    }

    public int getNUMERODEUNIDADES() {
        return this.numerodeunidades;
    }

    public void setNUMERODEUNIDADES(int i) {
        this.numerodeunidades = i;
    }
}
