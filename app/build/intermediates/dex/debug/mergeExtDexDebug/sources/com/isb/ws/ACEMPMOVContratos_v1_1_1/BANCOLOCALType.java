package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BANCO_LOCAL_Type", propOrder = {"pais", "valorbancolocal"})
public class BANCOLOCALType {
    @XmlElement(name = "PAIS", required = true)
    protected String pais;
    @XmlElement(name = "VALOR_BANCO_LOCAL", required = true)
    protected String valorbancolocal;

    public String getPAIS() {
        return this.pais;
    }

    public void setPAIS(String str) {
        this.pais = str;
    }

    public String getVALORBANCOLOCAL() {
        return this.valorbancolocal;
    }

    public void setVALORBANCOLOCAL(String str) {
        this.valorbancolocal = str;
    }
}
