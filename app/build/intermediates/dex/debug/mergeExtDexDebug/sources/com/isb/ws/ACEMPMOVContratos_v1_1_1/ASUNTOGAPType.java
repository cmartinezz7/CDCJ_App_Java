package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ASUNTO_GAP_Type", propOrder = {"codigodeasunto", "centro"})
public class ASUNTOGAPType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlElement(name = "CODIGO_DE_ASUNTO", required = true)
    protected String codigodeasunto;

    public String getCODIGODEASUNTO() {
        return this.codigodeasunto;
    }

    public void setCODIGODEASUNTO(String str) {
        this.codigodeasunto = str;
    }

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }
}
