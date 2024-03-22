package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHAVE_PONTO_VENDA_BR_Type", propOrder = {"indicador1", "pontodevenda", "indicador2"})
public class CHAVEPONTOVENDABRType {
    @XmlElement(name = "INDICADOR1", required = true)
    protected String indicador1;
    @XmlElement(name = "INDICADOR2", required = true)
    protected String indicador2;
    @XmlElement(name = "PONTO_DE_VENDA", required = true)
    protected String pontodevenda;

    public String getINDICADOR1() {
        return this.indicador1;
    }

    public void setINDICADOR1(String str) {
        this.indicador1 = str;
    }

    public String getPONTODEVENDA() {
        return this.pontodevenda;
    }

    public void setPONTODEVENDA(String str) {
        this.pontodevenda = str;
    }

    public String getINDICADOR2() {
        return this.indicador2;
    }

    public void setINDICADOR2(String str) {
        this.indicador2 = str;
    }
}
