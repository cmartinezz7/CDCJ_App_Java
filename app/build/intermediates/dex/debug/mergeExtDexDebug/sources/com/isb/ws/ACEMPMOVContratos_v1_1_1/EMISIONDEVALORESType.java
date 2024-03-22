package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EMISION_DE_VALORES_Type", propOrder = {"codigodevalor", "codigodeemision"})
public class EMISIONDEVALORESType {
    @XmlElement(name = "CODIGO_DE_EMISION", required = true)
    protected String codigodeemision;
    @XmlElement(name = "CODIGO_DE_VALOR", required = true)
    protected String codigodevalor;

    public String getCODIGODEVALOR() {
        return this.codigodevalor;
    }

    public void setCODIGODEVALOR(String str) {
        this.codigodevalor = str;
    }

    public String getCODIGODEEMISION() {
        return this.codigodeemision;
    }

    public void setCODIGODEEMISION(String str) {
        this.codigodeemision = str;
    }
}
