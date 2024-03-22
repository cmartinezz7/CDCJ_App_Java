package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESTADO_CRC_Type", propOrder = {"flujocrc", "codestado"})
public class ESTADOCRCType {
    @XmlElement(name = "COD_ESTADO", required = true)
    protected String codestado;
    @XmlElement(name = "FLUJO_CRC", required = true)
    protected FLUJOCRCType flujocrc;

    public FLUJOCRCType getFLUJOCRC() {
        return this.flujocrc;
    }

    public void setFLUJOCRC(FLUJOCRCType fLUJOCRCType) {
        this.flujocrc = fLUJOCRCType;
    }

    public String getCODESTADO() {
        return this.codestado;
    }

    public void setCODESTADO(String str) {
        this.codestado = str;
    }
}
