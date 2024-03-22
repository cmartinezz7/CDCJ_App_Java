package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FORMATO_ATRIB_CONTR_AVISO_Type", propOrder = {"codformato", "longitud"})
public class FORMATOATRIBCONTRAVISOType {
    @XmlElement(name = "COD_FORMATO", required = true)
    protected String codformato;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "LONGITUD")
    protected int longitud;

    public String getCODFORMATO() {
        return this.codformato;
    }

    public void setCODFORMATO(String str) {
        this.codformato = str;
    }

    public int getLONGITUD() {
        return this.longitud;
    }

    public void setLONGITUD(int i) {
        this.longitud = i;
    }
}
