package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHAVE_SEG_PRI_PF_BR_Type", propOrder = {"segmentopripfbr", "tipodepersonabr", "classe"})
public class CHAVESEGPRIPFBRType {
    @XmlElement(name = "CLASSE", required = true)
    protected String classe;
    @XmlElement(name = "SEGMENTO_PRI_PF_BR", required = true)
    protected String segmentopripfbr;
    @XmlElement(name = "TIPO_DE_PERSONA_BR", required = true)
    protected String tipodepersonabr;

    public String getSEGMENTOPRIPFBR() {
        return this.segmentopripfbr;
    }

    public void setSEGMENTOPRIPFBR(String str) {
        this.segmentopripfbr = str;
    }

    public String getTIPODEPERSONABR() {
        return this.tipodepersonabr;
    }

    public void setTIPODEPERSONABR(String str) {
        this.tipodepersonabr = str;
    }

    public String getCLASSE() {
        return this.classe;
    }

    public void setCLASSE(String str) {
        this.classe = str;
    }
}
