package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AGRUPACION_DE_PRODUCTOS_Type", propOrder = {"empresa", "codigoagrupacion"})
public class AGRUPACIONDEPRODUCTOSType {
    @XmlElement(name = "CODIGO_AGRUPACION", required = true)
    protected String codigoagrupacion;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODIGOAGRUPACION() {
        return this.codigoagrupacion;
    }

    public void setCODIGOAGRUPACION(String str) {
        this.codigoagrupacion = str;
    }
}
