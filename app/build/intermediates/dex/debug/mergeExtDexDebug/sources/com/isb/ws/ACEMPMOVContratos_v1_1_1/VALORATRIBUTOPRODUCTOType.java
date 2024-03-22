package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VALOR_ATRIBUTO_PRODUCTO_Type", propOrder = {"codatributoproducto", "valoratributoprod"})
public class VALORATRIBUTOPRODUCTOType {
    @XmlElement(name = "COD_ATRIBUTO_PRODUCTO", required = true)
    protected String codatributoproducto;
    @XmlElement(name = "VALOR_ATRIBUTO_PROD", required = true)
    protected String valoratributoprod;

    public String getCODATRIBUTOPRODUCTO() {
        return this.codatributoproducto;
    }

    public void setCODATRIBUTOPRODUCTO(String str) {
        this.codatributoproducto = str;
    }

    public String getVALORATRIBUTOPROD() {
        return this.valoratributoprod;
    }

    public void setVALORATRIBUTOPROD(String str) {
        this.valoratributoprod = str;
    }
}
