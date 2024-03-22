package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONDICIO_AVISO_CONEX_CTAS_Type", propOrder = {"circuito", "opcion1AVISO", "opcion2AVISO", "opcion3AVISO"})
public class CONDICIOAVISOCONEXCTASType {
    @XmlElement(name = "CIRCUITO", required = true)
    protected String circuito;
    @XmlElement(name = "OPCION_1_AVISO", required = true)
    protected String opcion1AVISO;
    @XmlElement(name = "OPCION_2_AVISO", required = true)
    protected String opcion2AVISO;
    @XmlElement(name = "OPCION_3_AVISO", required = true)
    protected String opcion3AVISO;

    public String getCIRCUITO() {
        return this.circuito;
    }

    public void setCIRCUITO(String str) {
        this.circuito = str;
    }

    public String getOPCION1AVISO() {
        return this.opcion1AVISO;
    }

    public void setOPCION1AVISO(String str) {
        this.opcion1AVISO = str;
    }

    public String getOPCION2AVISO() {
        return this.opcion2AVISO;
    }

    public void setOPCION2AVISO(String str) {
        this.opcion2AVISO = str;
    }

    public String getOPCION3AVISO() {
        return this.opcion3AVISO;
    }

    public void setOPCION3AVISO(String str) {
        this.opcion3AVISO = str;
    }
}
