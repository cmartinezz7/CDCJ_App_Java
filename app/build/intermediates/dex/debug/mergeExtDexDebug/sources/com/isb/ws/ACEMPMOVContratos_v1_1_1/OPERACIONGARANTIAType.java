package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OPERACION_GARANTIA_Type", propOrder = {"tipooperaciongarantia", "valortipoopergarantia"})
public class OPERACIONGARANTIAType {
    @XmlElement(name = "TIPO_OPERACION_GARANTIA", required = true)
    protected TIPOOPERACIONGARANTIAType tipooperaciongarantia;
    @XmlElement(name = "VALOR_TIPO_OPER_GARANTIA", required = true)
    protected String valortipoopergarantia;

    public TIPOOPERACIONGARANTIAType getTIPOOPERACIONGARANTIA() {
        return this.tipooperaciongarantia;
    }

    public void setTIPOOPERACIONGARANTIA(TIPOOPERACIONGARANTIAType tIPOOPERACIONGARANTIAType) {
        this.tipooperaciongarantia = tIPOOPERACIONGARANTIAType;
    }

    public String getVALORTIPOOPERGARANTIA() {
        return this.valortipoopergarantia;
    }

    public void setVALORTIPOOPERGARANTIA(String str) {
        this.valortipoopergarantia = str;
    }
}
