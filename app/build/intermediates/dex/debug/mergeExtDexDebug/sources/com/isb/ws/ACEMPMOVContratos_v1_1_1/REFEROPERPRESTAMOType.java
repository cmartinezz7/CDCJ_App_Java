package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REFER_OPER_PRESTAMO_Type", propOrder = {"contrato", "operacionbasica", "secuencialcorto"})
public class REFEROPERPRESTAMOType {
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;
    @XmlElement(name = "OPERACION_BASICA", required = true)
    protected String operacionbasica;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "SECUENCIAL_CORTO")
    protected int secuencialcorto;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public String getOPERACIONBASICA() {
        return this.operacionbasica;
    }

    public void setOPERACIONBASICA(String str) {
        this.operacionbasica = str;
    }

    public int getSECUENCIALCORTO() {
        return this.secuencialcorto;
    }

    public void setSECUENCIALCORTO(int i) {
        this.secuencialcorto = i;
    }
}
