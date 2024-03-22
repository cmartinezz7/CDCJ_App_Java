package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VALOR_CAMPO_PARAM_SEG_Type", propOrder = {"parametrocampo", "valorcampo"})
public class VALORCAMPOPARAMSEGType {
    @XmlElement(name = "PARAMETRO_CAMPO", required = true)
    protected String parametrocampo;
    @XmlElement(name = "VALOR_CAMPO", required = true)
    protected String valorcampo;

    public String getPARAMETROCAMPO() {
        return this.parametrocampo;
    }

    public void setPARAMETROCAMPO(String str) {
        this.parametrocampo = str;
    }

    public String getVALORCAMPO() {
        return this.valorcampo;
    }

    public void setVALORCAMPO(String str) {
        this.valorcampo = str;
    }
}
