package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHAVE_TIPO_FATURA_BR_Type", propOrder = {"tipofaturabr", "indnormalcorretorabr"})
public class CHAVETIPOFATURABRType {
    @XmlElement(name = "IND_NORMAL_CORRETORA_BR", required = true)
    protected String indnormalcorretorabr;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "TIPO_FATURA_BR")
    protected int tipofaturabr;

    public int getTIPOFATURABR() {
        return this.tipofaturabr;
    }

    public void setTIPOFATURABR(int i) {
        this.tipofaturabr = i;
    }

    public String getINDNORMALCORRETORABR() {
        return this.indnormalcorretorabr;
    }

    public void setINDNORMALCORRETORABR(String str) {
        this.indnormalcorretorabr = str;
    }
}
