package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REGLA_2_AVISO_Type", propOrder = {"regla1AVISO", "codopcion2"})
public class REGLA2AVISOType {
    @XmlElement(name = "COD_OPCION_2", required = true)
    protected String codopcion2;
    @XmlElement(name = "REGLA_1_AVISO", required = true)
    protected REGLA1AVISOType regla1AVISO;

    public REGLA1AVISOType getREGLA1AVISO() {
        return this.regla1AVISO;
    }

    public void setREGLA1AVISO(REGLA1AVISOType rEGLA1AVISOType) {
        this.regla1AVISO = rEGLA1AVISOType;
    }

    public String getCODOPCION2() {
        return this.codopcion2;
    }

    public void setCODOPCION2(String str) {
        this.codopcion2 = str;
    }
}
