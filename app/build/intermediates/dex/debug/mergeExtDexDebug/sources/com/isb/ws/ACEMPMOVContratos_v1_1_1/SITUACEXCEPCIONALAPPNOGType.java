package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SITUAC_EXCEPCIONAL_APPNOG_Type", propOrder = {"procesodenegocio", "canal", "codsitexcepcional"})
public class SITUACEXCEPCIONALAPPNOGType {
    @XmlElement(name = "CANAL", required = true)
    protected String canal;
    @XmlElement(name = "COD_SIT_EXCEPCIONAL", required = true)
    protected String codsitexcepcional;
    @XmlElement(name = "PROCESO_DE_NEGOCIO", required = true)
    protected PROCESODENEGOCIOType procesodenegocio;

    public PROCESODENEGOCIOType getPROCESODENEGOCIO() {
        return this.procesodenegocio;
    }

    public void setPROCESODENEGOCIO(PROCESODENEGOCIOType pROCESODENEGOCIOType) {
        this.procesodenegocio = pROCESODENEGOCIOType;
    }

    public String getCANAL() {
        return this.canal;
    }

    public void setCANAL(String str) {
        this.canal = str;
    }

    public String getCODSITEXCEPCIONAL() {
        return this.codsitexcepcional;
    }

    public void setCODSITEXCEPCIONAL(String str) {
        this.codsitexcepcional = str;
    }
}
