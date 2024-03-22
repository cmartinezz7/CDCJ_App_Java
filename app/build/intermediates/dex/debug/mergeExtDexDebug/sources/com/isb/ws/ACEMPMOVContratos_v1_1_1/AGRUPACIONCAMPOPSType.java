package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AGRUPACION_CAMPO_PS_Type", propOrder = {"tipoagrupacioncampops", "codigodecampo"})
public class AGRUPACIONCAMPOPSType {
    @XmlElement(name = "CODIGO_DE_CAMPO", required = true)
    protected String codigodecampo;
    @XmlElement(name = "TIPO_AGRUPACION_CAMPO_PS", required = true)
    protected TIPOAGRUPACIONCAMPOPSType tipoagrupacioncampops;

    public TIPOAGRUPACIONCAMPOPSType getTIPOAGRUPACIONCAMPOPS() {
        return this.tipoagrupacioncampops;
    }

    public void setTIPOAGRUPACIONCAMPOPS(TIPOAGRUPACIONCAMPOPSType tIPOAGRUPACIONCAMPOPSType) {
        this.tipoagrupacioncampops = tIPOAGRUPACIONCAMPOPSType;
    }

    public String getCODIGODECAMPO() {
        return this.codigodecampo;
    }

    public void setCODIGODECAMPO(String str) {
        this.codigodecampo = str;
    }
}
