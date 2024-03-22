package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GA_ESTRUCTURA_OPERACION_Type", propOrder = {"operaciongarantia", "codigocentro", "codigoestructura"})
public class GAESTRUCTURAOPERACIONType {
    @XmlElement(name = "CODIGO_CENTRO", required = true)
    protected String codigocentro;
    @XmlElement(name = "CODIGO_ESTRUCTURA", required = true)
    protected String codigoestructura;
    @XmlElement(name = "OPERACION_GARANTIA", required = true)
    protected OPERACIONGARANTIAType operaciongarantia;

    public OPERACIONGARANTIAType getOPERACIONGARANTIA() {
        return this.operaciongarantia;
    }

    public void setOPERACIONGARANTIA(OPERACIONGARANTIAType oPERACIONGARANTIAType) {
        this.operaciongarantia = oPERACIONGARANTIAType;
    }

    public String getCODIGOCENTRO() {
        return this.codigocentro;
    }

    public void setCODIGOCENTRO(String str) {
        this.codigocentro = str;
    }

    public String getCODIGOESTRUCTURA() {
        return this.codigoestructura;
    }

    public void setCODIGOESTRUCTURA(String str) {
        this.codigoestructura = str;
    }
}
