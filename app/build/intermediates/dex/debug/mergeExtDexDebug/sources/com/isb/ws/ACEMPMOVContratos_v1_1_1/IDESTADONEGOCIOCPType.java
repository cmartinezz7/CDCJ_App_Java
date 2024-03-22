package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_ESTADO_NEGOCIO_CP_Type", propOrder = {"procesodenegocio", "codestadopn"})
public class IDESTADONEGOCIOCPType {
    @XmlElement(name = "COD_ESTADO_PN", required = true)
    protected String codestadopn;
    @XmlElement(name = "PROCESO_DE_NEGOCIO", required = true)
    protected PROCESODENEGOCIOType procesodenegocio;

    public PROCESODENEGOCIOType getPROCESODENEGOCIO() {
        return this.procesodenegocio;
    }

    public void setPROCESODENEGOCIO(PROCESODENEGOCIOType pROCESODENEGOCIOType) {
        this.procesodenegocio = pROCESODENEGOCIOType;
    }

    public String getCODESTADOPN() {
        return this.codestadopn;
    }

    public void setCODESTADOPN(String str) {
        this.codestadopn = str;
    }
}
