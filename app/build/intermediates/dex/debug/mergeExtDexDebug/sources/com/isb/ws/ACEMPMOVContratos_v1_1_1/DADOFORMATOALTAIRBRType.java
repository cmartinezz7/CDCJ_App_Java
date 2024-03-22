package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DADO_FORMATO_ALTAIR_BR_Type", propOrder = {"aplicacaoaltairbr", "campoaltairbr", "valoraltairbr"})
public class DADOFORMATOALTAIRBRType {
    @XmlElement(name = "APLICACAO_ALTAIR_BR", required = true)
    protected String aplicacaoaltairbr;
    @XmlElement(name = "CAMPO_ALTAIR_BR", required = true)
    protected String campoaltairbr;
    @XmlElement(name = "VALOR_ALTAIR_BR", required = true)
    protected String valoraltairbr;

    public String getAPLICACAOALTAIRBR() {
        return this.aplicacaoaltairbr;
    }

    public void setAPLICACAOALTAIRBR(String str) {
        this.aplicacaoaltairbr = str;
    }

    public String getCAMPOALTAIRBR() {
        return this.campoaltairbr;
    }

    public void setCAMPOALTAIRBR(String str) {
        this.campoaltairbr = str;
    }

    public String getVALORALTAIRBR() {
        return this.valoraltairbr;
    }

    public void setVALORALTAIRBR(String str) {
        this.valoraltairbr = str;
    }
}
