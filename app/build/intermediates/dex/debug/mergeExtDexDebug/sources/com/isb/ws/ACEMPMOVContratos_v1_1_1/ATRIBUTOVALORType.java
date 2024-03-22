package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ATRIBUTO_VALOR_Type", propOrder = {"codatributoproducto", "valor1", "valor2", "valor3"})
public class ATRIBUTOVALORType {
    @XmlElement(name = "COD_ATRIBUTO_PRODUCTO", required = true)
    protected String codatributoproducto;
    @XmlElement(name = "VALOR_1", required = true)
    protected String valor1;
    @XmlElement(name = "VALOR_2", required = true)
    protected String valor2;
    @XmlElement(name = "VALOR_3", required = true)
    protected String valor3;

    public String getCODATRIBUTOPRODUCTO() {
        return this.codatributoproducto;
    }

    public void setCODATRIBUTOPRODUCTO(String str) {
        this.codatributoproducto = str;
    }

    public String getVALOR1() {
        return this.valor1;
    }

    public void setVALOR1(String str) {
        this.valor1 = str;
    }

    public String getVALOR2() {
        return this.valor2;
    }

    public void setVALOR2(String str) {
        this.valor2 = str;
    }

    public String getVALOR3() {
        return this.valor3;
    }

    public void setVALOR3(String str) {
        this.valor3 = str;
    }
}
