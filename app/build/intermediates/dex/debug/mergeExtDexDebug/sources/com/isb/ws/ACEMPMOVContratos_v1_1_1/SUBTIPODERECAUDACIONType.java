package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBTIPO_DE_RECAUDACION_Type", propOrder = {"tipoderecaudacion", "codigodesubtipo"})
public class SUBTIPODERECAUDACIONType {
    @XmlElement(name = "CODIGO_DE_SUBTIPO", required = true)
    protected String codigodesubtipo;
    @XmlElement(name = "TIPO_DE_RECAUDACION", required = true)
    protected String tipoderecaudacion;

    public String getTIPODERECAUDACION() {
        return this.tipoderecaudacion;
    }

    public void setTIPODERECAUDACION(String str) {
        this.tipoderecaudacion = str;
    }

    public String getCODIGODESUBTIPO() {
        return this.codigodesubtipo;
    }

    public void setCODIGODESUBTIPO(String str) {
        this.codigodesubtipo = str;
    }
}
