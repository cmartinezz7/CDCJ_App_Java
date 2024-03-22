package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OPERACION_DGO_Type", propOrder = {"centro", "codigoterminaldgo", "numerodgo"})
public class OPERACIONDGOType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTRODECONTRATOType centro;
    @XmlElement(name = "CODIGO_TERMINAL_DGO", required = true)
    protected String codigoterminaldgo;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUMERO_DGO")
    protected int numerodgo;

    public CENTRODECONTRATOType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTRODECONTRATOType cENTRODECONTRATOType) {
        this.centro = cENTRODECONTRATOType;
    }

    public String getCODIGOTERMINALDGO() {
        return this.codigoterminaldgo;
    }

    public void setCODIGOTERMINALDGO(String str) {
        this.codigoterminaldgo = str;
    }

    public int getNUMERODGO() {
        return this.numerodgo;
    }

    public void setNUMERODGO(int i) {
        this.numerodgo = i;
    }
}
