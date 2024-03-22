package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_PRESENTACION_GEM_Type", propOrder = {"operaciongem", "codtipopresent"})
public class TIPOPRESENTACIONGEMType {
    @XmlElement(name = "COD_TIPO_PRESENT", required = true)
    protected String codtipopresent;
    @XmlElement(name = "OPERACION_GEM", required = true)
    protected OPERACIONGEMType operaciongem;

    public OPERACIONGEMType getOPERACIONGEM() {
        return this.operaciongem;
    }

    public void setOPERACIONGEM(OPERACIONGEMType oPERACIONGEMType) {
        this.operaciongem = oPERACIONGEMType;
    }

    public String getCODTIPOPRESENT() {
        return this.codtipopresent;
    }

    public void setCODTIPOPRESENT(String str) {
        this.codtipopresent = str;
    }
}
