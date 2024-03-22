package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBFASE_PN_Type", propOrder = {"procesodenegocio", "codigosubfase"})
public class SUBFASEPNType {
    @XmlElement(name = "CODIGO_SUBFASE", required = true)
    protected String codigosubfase;
    @XmlElement(name = "PROCESO_DE_NEGOCIO", required = true)
    protected PROCESODENEGOCIOType procesodenegocio;

    public PROCESODENEGOCIOType getPROCESODENEGOCIO() {
        return this.procesodenegocio;
    }

    public void setPROCESODENEGOCIO(PROCESODENEGOCIOType pROCESODENEGOCIOType) {
        this.procesodenegocio = pROCESODENEGOCIOType;
    }

    public String getCODIGOSUBFASE() {
        return this.codigosubfase;
    }

    public void setCODIGOSUBFASE(String str) {
        this.codigosubfase = str;
    }
}
