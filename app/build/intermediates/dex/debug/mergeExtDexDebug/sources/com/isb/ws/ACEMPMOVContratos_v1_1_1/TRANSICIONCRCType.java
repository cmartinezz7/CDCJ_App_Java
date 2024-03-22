package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRANSICION_CRC_Type", propOrder = {"estadocrc", "codeventocrc"})
public class TRANSICIONCRCType {
    @XmlElement(name = "COD_EVENTO_CRC", required = true)
    protected String codeventocrc;
    @XmlElement(name = "ESTADO_CRC", required = true)
    protected ESTADOCRCType estadocrc;

    public ESTADOCRCType getESTADOCRC() {
        return this.estadocrc;
    }

    public void setESTADOCRC(ESTADOCRCType eSTADOCRCType) {
        this.estadocrc = eSTADOCRCType;
    }

    public String getCODEVENTOCRC() {
        return this.codeventocrc;
    }

    public void setCODEVENTOCRC(String str) {
        this.codeventocrc = str;
    }
}
