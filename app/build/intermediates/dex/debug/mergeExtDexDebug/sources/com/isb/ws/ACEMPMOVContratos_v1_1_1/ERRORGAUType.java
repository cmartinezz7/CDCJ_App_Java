package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ERROR_GAU_Type", propOrder = {"tipomotivo", "codmotivo"})
public class ERRORGAUType {
    @XmlElement(name = "COD_MOTIVO", required = true)
    protected String codmotivo;
    @XmlElement(name = "TIPO_MOTIVO", required = true)
    protected String tipomotivo;

    public String getTIPOMOTIVO() {
        return this.tipomotivo;
    }

    public void setTIPOMOTIVO(String str) {
        this.tipomotivo = str;
    }

    public String getCODMOTIVO() {
        return this.codmotivo;
    }

    public void setCODMOTIVO(String str) {
        this.codmotivo = str;
    }
}
