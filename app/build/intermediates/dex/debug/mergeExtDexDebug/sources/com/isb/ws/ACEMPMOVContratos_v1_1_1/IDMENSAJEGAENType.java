package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_MENSAJE_GAEN_Type", propOrder = {"procesodenegocio", "codtipmensaje"})
public class IDMENSAJEGAENType {
    @XmlElement(name = "COD_TIP_MENSAJE", required = true)
    protected String codtipmensaje;
    @XmlElement(name = "PROCESO_DE_NEGOCIO", required = true)
    protected PROCESODENEGOCIOType procesodenegocio;

    public PROCESODENEGOCIOType getPROCESODENEGOCIO() {
        return this.procesodenegocio;
    }

    public void setPROCESODENEGOCIO(PROCESODENEGOCIOType pROCESODENEGOCIOType) {
        this.procesodenegocio = pROCESODENEGOCIOType;
    }

    public String getCODTIPMENSAJE() {
        return this.codtipmensaje;
    }

    public void setCODTIPMENSAJE(String str) {
        this.codtipmensaje = str;
    }
}
