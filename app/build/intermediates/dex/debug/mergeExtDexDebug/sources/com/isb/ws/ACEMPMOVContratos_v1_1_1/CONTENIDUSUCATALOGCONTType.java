package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTENID_USU_CATALOG_CONT_Type", propOrder = {"usuarioportal", "codigocontenido"})
public class CONTENIDUSUCATALOGCONTType {
    @XmlElement(name = "CODIGO_CONTENIDO", required = true)
    protected String codigocontenido;
    @XmlElement(name = "USUARIO_PORTAL", required = true)
    protected String usuarioportal;

    public String getUSUARIOPORTAL() {
        return this.usuarioportal;
    }

    public void setUSUARIOPORTAL(String str) {
        this.usuarioportal = str;
    }

    public String getCODIGOCONTENIDO() {
        return this.codigocontenido;
    }

    public void setCODIGOCONTENIDO(String str) {
        this.codigocontenido = str;
    }
}
