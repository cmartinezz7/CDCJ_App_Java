package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOTIVO_PRODUCTO_Type", propOrder = {"subtipodeproducto", "tipodemotivo", "codigomotivo"})
public class MOTIVOPRODUCTOType {
    @XmlElement(name = "CODIGO_MOTIVO", required = true)
    protected String codigomotivo;
    @XmlElement(name = "SUBTIPO_DE_PRODUCTO", required = true)
    protected SUBTIPODEPRODUCTOType subtipodeproducto;
    @XmlElement(name = "TIPO_DE_MOTIVO", required = true)
    protected String tipodemotivo;

    public SUBTIPODEPRODUCTOType getSUBTIPODEPRODUCTO() {
        return this.subtipodeproducto;
    }

    public void setSUBTIPODEPRODUCTO(SUBTIPODEPRODUCTOType sUBTIPODEPRODUCTOType) {
        this.subtipodeproducto = sUBTIPODEPRODUCTOType;
    }

    public String getTIPODEMOTIVO() {
        return this.tipodemotivo;
    }

    public void setTIPODEMOTIVO(String str) {
        this.tipodemotivo = str;
    }

    public String getCODIGOMOTIVO() {
        return this.codigomotivo;
    }

    public void setCODIGOMOTIVO(String str) {
        this.codigomotivo = str;
    }
}
