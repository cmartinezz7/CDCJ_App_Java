package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CODIGO_CVC_Type", propOrder = {"denomatributo", "valoratributo"})
public class CODIGOCVCType {
    @XmlElement(name = "DENOM_ATRIBUTO", required = true)
    protected String denomatributo;
    @XmlElement(name = "VALOR_ATRIBUTO", required = true)
    protected String valoratributo;

    public String getDENOMATRIBUTO() {
        return this.denomatributo;
    }

    public void setDENOMATRIBUTO(String str) {
        this.denomatributo = str;
    }

    public String getVALORATRIBUTO() {
        return this.valoratributo;
    }

    public void setVALORATRIBUTO(String str) {
        this.valoratributo = str;
    }
}
