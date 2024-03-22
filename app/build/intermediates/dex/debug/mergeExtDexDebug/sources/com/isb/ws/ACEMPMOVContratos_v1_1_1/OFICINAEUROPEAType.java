package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OFICINA_EUROPEA_Type", propOrder = {"pais", "codigoalfanum10"})
public class OFICINAEUROPEAType {
    @XmlElement(name = "CODIGO_ALFANUM_10", required = true)
    protected String codigoalfanum10;
    @XmlElement(name = "PAIS", required = true)
    protected String pais;

    public String getPAIS() {
        return this.pais;
    }

    public void setPAIS(String str) {
        this.pais = str;
    }

    public String getCODIGOALFANUM10() {
        return this.codigoalfanum10;
    }

    public void setCODIGOALFANUM10(String str) {
        this.codigoalfanum10 = str;
    }
}
