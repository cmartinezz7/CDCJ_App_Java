package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AGRUPADOR_BNF_Type", propOrder = {"centro", "codagrupador"})
public class AGRUPADORBNFType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlElement(name = "COD_AGRUPADOR", required = true)
    protected String codagrupador;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public String getCODAGRUPADOR() {
        return this.codagrupador;
    }

    public void setCODAGRUPADOR(String str) {
        this.codagrupador = str;
    }
}
