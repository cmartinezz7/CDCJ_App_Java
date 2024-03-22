package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APLICACION_DESTINO_GEM_Type", propOrder = {"operaciongem", "codaplicaciondest"})
public class APLICACIONDESTINOGEMType {
    @XmlElement(name = "COD_APLICACION_DEST", required = true)
    protected String codaplicaciondest;
    @XmlElement(name = "OPERACION_GEM", required = true)
    protected OPERACIONGEMType operaciongem;

    public OPERACIONGEMType getOPERACIONGEM() {
        return this.operaciongem;
    }

    public void setOPERACIONGEM(OPERACIONGEMType oPERACIONGEMType) {
        this.operaciongem = oPERACIONGEMType;
    }

    public String getCODAPLICACIONDEST() {
        return this.codaplicaciondest;
    }

    public void setCODAPLICACIONDEST(String str) {
        this.codaplicaciondest = str;
    }
}
