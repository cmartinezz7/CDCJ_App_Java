package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTRATO_VIEJO_Type", propOrder = {"centro", "subgrupo", "numerodecontrato"})
public class CONTRATOVIEJOType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTRODECONTRATOType centro;
    @XmlElement(name = "NUMERO_DE_CONTRATO", required = true)
    protected String numerodecontrato;
    @XmlElement(name = "SUBGRUPO", required = true)
    protected String subgrupo;

    public CENTRODECONTRATOType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTRODECONTRATOType cENTRODECONTRATOType) {
        this.centro = cENTRODECONTRATOType;
    }

    public String getSUBGRUPO() {
        return this.subgrupo;
    }

    public void setSUBGRUPO(String str) {
        this.subgrupo = str;
    }

    public String getNUMERODECONTRATO() {
        return this.numerodecontrato;
    }

    public void setNUMERODECONTRATO(String str) {
        this.numerodecontrato = str;
    }
}
