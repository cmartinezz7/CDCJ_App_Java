package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PERFIL_TITUS_Type", propOrder = {"codproyectotitus", "titus"})
public class PERFILTITUSType {
    @XmlElement(name = "COD_PROYECTO_TITUS", required = true)
    protected String codproyectotitus;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "TITUS")
    protected int titus;

    public String getCODPROYECTOTITUS() {
        return this.codproyectotitus;
    }

    public void setCODPROYECTOTITUS(String str) {
        this.codproyectotitus = str;
    }

    public int getTITUS() {
        return this.titus;
    }

    public void setTITUS(int i) {
        this.titus = i;
    }
}
