package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NOMBRE_CORPORATIVO_Type", propOrder = {"tiponombre", "nombretransito", "restonombre"})
public class NOMBRECORPORATIVOType {
    @XmlElement(name = "NOMBRE_TRANSITO", required = true)
    protected String nombretransito;
    @XmlElement(name = "RESTO_NOMBRE", required = true)
    protected String restonombre;
    @XmlElement(name = "TIPO_NOMBRE", required = true)
    protected String tiponombre;

    public String getTIPONOMBRE() {
        return this.tiponombre;
    }

    public void setTIPONOMBRE(String str) {
        this.tiponombre = str;
    }

    public String getNOMBRETRANSITO() {
        return this.nombretransito;
    }

    public void setNOMBRETRANSITO(String str) {
        this.nombretransito = str;
    }

    public String getRESTONOMBRE() {
        return this.restonombre;
    }

    public void setRESTONOMBRE(String str) {
        this.restonombre = str;
    }
}
