package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESTADO_ID_SOLICITUD_PN_Type", propOrder = {"procesodenegocio", "estadopn"})
public class ESTADOIDSOLICITUDPNType {
    @XmlElement(name = "ESTADO_PN", required = true)
    protected String estadopn;
    @XmlElement(name = "PROCESO_DE_NEGOCIO", required = true)
    protected PROCESODENEGOCIOType procesodenegocio;

    public PROCESODENEGOCIOType getPROCESODENEGOCIO() {
        return this.procesodenegocio;
    }

    public void setPROCESODENEGOCIO(PROCESODENEGOCIOType pROCESODENEGOCIOType) {
        this.procesodenegocio = pROCESODENEGOCIOType;
    }

    public String getESTADOPN() {
        return this.estadopn;
    }

    public void setESTADOPN(String str) {
        this.estadopn = str;
    }
}
