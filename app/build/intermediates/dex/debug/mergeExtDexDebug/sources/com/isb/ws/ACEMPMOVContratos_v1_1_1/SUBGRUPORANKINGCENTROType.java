package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBGRUPO_RANKING_CENTRO_Type", propOrder = {"gruporankingcentro", "codalfanum2"})
public class SUBGRUPORANKINGCENTROType {
    @XmlElement(name = "COD_ALFANUM_2", required = true)
    protected String codalfanum2;
    @XmlElement(name = "GRUPO_RANKING_CENTRO", required = true)
    protected String gruporankingcentro;

    public String getGRUPORANKINGCENTRO() {
        return this.gruporankingcentro;
    }

    public void setGRUPORANKINGCENTRO(String str) {
        this.gruporankingcentro = str;
    }

    public String getCODALFANUM2() {
        return this.codalfanum2;
    }

    public void setCODALFANUM2(String str) {
        this.codalfanum2 = str;
    }
}
