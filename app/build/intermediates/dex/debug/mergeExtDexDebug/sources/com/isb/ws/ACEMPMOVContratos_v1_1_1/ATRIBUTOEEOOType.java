package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ATRIBUTO_EEOO_Type", propOrder = {"tipodeunidadeeoo", "codatributo"})
public class ATRIBUTOEEOOType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_ATRIBUTO")
    protected int codatributo;
    @XmlElement(name = "TIPO_DE_UNIDAD_EEOO", required = true)
    protected TIPODEUNIDADEEOOType tipodeunidadeeoo;

    public TIPODEUNIDADEEOOType getTIPODEUNIDADEEOO() {
        return this.tipodeunidadeeoo;
    }

    public void setTIPODEUNIDADEEOO(TIPODEUNIDADEEOOType tIPODEUNIDADEEOOType) {
        this.tipodeunidadeeoo = tIPODEUNIDADEEOOType;
    }

    public int getCODATRIBUTO() {
        return this.codatributo;
    }

    public void setCODATRIBUTO(int i) {
        this.codatributo = i;
    }
}
