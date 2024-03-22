package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REGLA_3_AVISO_Type", propOrder = {"regla2AVISO", "codopcion3"})
public class REGLA3AVISOType {
    @XmlElement(name = "COD_OPCION_3", required = true)
    protected String codopcion3;
    @XmlElement(name = "REGLA_2_AVISO", required = true)
    protected REGLA2AVISOType regla2AVISO;

    public REGLA2AVISOType getREGLA2AVISO() {
        return this.regla2AVISO;
    }

    public void setREGLA2AVISO(REGLA2AVISOType rEGLA2AVISOType) {
        this.regla2AVISO = rEGLA2AVISOType;
    }

    public String getCODOPCION3() {
        return this.codopcion3;
    }

    public void setCODOPCION3(String str) {
        this.codopcion3 = str;
    }
}
