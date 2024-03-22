package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHAVE_TIPO_RESIDENCIA_BR_Type", propOrder = {"tiporesidenciabr", "indicador"})
public class CHAVETIPORESIDENCIABRType {
    @XmlElement(name = "INDICADOR", required = true)
    protected String indicador;
    @XmlElement(name = "TIPO_RESIDENCIA_BR", required = true)
    protected String tiporesidenciabr;

    public String getTIPORESIDENCIABR() {
        return this.tiporesidenciabr;
    }

    public void setTIPORESIDENCIABR(String str) {
        this.tiporesidenciabr = str;
    }

    public String getINDICADOR() {
        return this.indicador;
    }

    public void setINDICADOR(String str) {
        this.indicador = str;
    }
}
