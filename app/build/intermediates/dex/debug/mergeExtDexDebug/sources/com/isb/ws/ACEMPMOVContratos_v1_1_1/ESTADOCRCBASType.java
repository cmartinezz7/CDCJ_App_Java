package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESTADO_CRCBAS_Type", propOrder = {"flujocrcbas", "codestado"})
public class ESTADOCRCBASType {
    @XmlElement(name = "COD_ESTADO", required = true)
    protected String codestado;
    @XmlElement(name = "FLUJO_CRCBAS", required = true)
    protected FLUJOCRCBASType flujocrcbas;

    public FLUJOCRCBASType getFLUJOCRCBAS() {
        return this.flujocrcbas;
    }

    public void setFLUJOCRCBAS(FLUJOCRCBASType fLUJOCRCBASType) {
        this.flujocrcbas = fLUJOCRCBASType;
    }

    public String getCODESTADO() {
        return this.codestado;
    }

    public void setCODESTADO(String str) {
        this.codestado = str;
    }
}
