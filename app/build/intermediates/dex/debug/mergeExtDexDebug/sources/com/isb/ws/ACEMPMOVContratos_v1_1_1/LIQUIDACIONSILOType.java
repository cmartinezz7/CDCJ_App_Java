package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LIQUIDACION_SILO_Type", propOrder = {"centro", "vendedoronce", "fechaliquidacion", "tipoliquidacionsilo", "codigonumerico"})
public class LIQUIDACIONSILOType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_NUMERICO")
    protected int codigonumerico;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_LIQUIDACION", required = true)
    protected XMLGregorianCalendar fechaliquidacion;
    @XmlElement(name = "TIPO_LIQUIDACION_SILO", required = true)
    protected String tipoliquidacionsilo;
    @XmlElement(name = "VENDEDOR_ONCE", required = true)
    protected String vendedoronce;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public String getVENDEDORONCE() {
        return this.vendedoronce;
    }

    public void setVENDEDORONCE(String str) {
        this.vendedoronce = str;
    }

    public XMLGregorianCalendar getFECHALIQUIDACION() {
        return this.fechaliquidacion;
    }

    public void setFECHALIQUIDACION(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechaliquidacion = xMLGregorianCalendar;
    }

    public String getTIPOLIQUIDACIONSILO() {
        return this.tipoliquidacionsilo;
    }

    public void setTIPOLIQUIDACIONSILO(String str) {
        this.tipoliquidacionsilo = str;
    }

    public int getCODIGONUMERICO() {
        return this.codigonumerico;
    }

    public void setCODIGONUMERICO(int i) {
        this.codigonumerico = i;
    }
}
