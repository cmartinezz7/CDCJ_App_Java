package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ROL_DE_NEGOCIO_Type", propOrder = {"procesodenegocio", "roldenegocio"})
public class ROLDENEGOCIOType {
    @XmlElement(name = "PROCESO_DE_NEGOCIO", required = true)
    protected PROCESODENEGOCIOType procesodenegocio;
    @XmlElement(name = "ROL_DE_NEGOCIO", required = true)
    protected String roldenegocio;

    public PROCESODENEGOCIOType getPROCESODENEGOCIO() {
        return this.procesodenegocio;
    }

    public void setPROCESODENEGOCIO(PROCESODENEGOCIOType pROCESODENEGOCIOType) {
        this.procesodenegocio = pROCESODENEGOCIOType;
    }

    public String getROLDENEGOCIO() {
        return this.roldenegocio;
    }

    public void setROLDENEGOCIO(String str) {
        this.roldenegocio = str;
    }
}
