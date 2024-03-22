package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_CONCEPTO_AT_Type", propOrder = {"empresa", "canalbasico", "componenteat", "codconcepto"})
public class IDCONCEPTOATType {
    @XmlElement(name = "CANAL_BASICO", required = true)
    protected String canalbasico;
    @XmlElement(name = "COD_CONCEPTO", required = true)
    protected String codconcepto;
    @XmlElement(name = "COMPONENTE_AT", required = true)
    protected String componenteat;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCANALBASICO() {
        return this.canalbasico;
    }

    public void setCANALBASICO(String str) {
        this.canalbasico = str;
    }

    public String getCOMPONENTEAT() {
        return this.componenteat;
    }

    public void setCOMPONENTEAT(String str) {
        this.componenteat = str;
    }

    public String getCODCONCEPTO() {
        return this.codconcepto;
    }

    public void setCODCONCEPTO(String str) {
        this.codconcepto = str;
    }
}
