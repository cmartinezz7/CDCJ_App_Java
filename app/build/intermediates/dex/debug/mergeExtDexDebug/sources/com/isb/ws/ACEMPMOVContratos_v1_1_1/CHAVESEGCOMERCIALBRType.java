package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHAVE_SEG_COMERCIAL_BR_Type", propOrder = {"tiposegcomercialbr", "segmentocomercialbr"})
public class CHAVESEGCOMERCIALBRType {
    @XmlElement(name = "SEGMENTO_COMERCIAL_BR", required = true)
    protected String segmentocomercialbr;
    @XmlElement(name = "TIPO_SEG_COMERCIAL_BR", required = true)
    protected String tiposegcomercialbr;

    public String getTIPOSEGCOMERCIALBR() {
        return this.tiposegcomercialbr;
    }

    public void setTIPOSEGCOMERCIALBR(String str) {
        this.tiposegcomercialbr = str;
    }

    public String getSEGMENTOCOMERCIALBR() {
        return this.segmentocomercialbr;
    }

    public void setSEGMENTOCOMERCIALBR(String str) {
        this.segmentocomercialbr = str;
    }
}
