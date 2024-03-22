package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AGRUPADOR_RIESGOS_Type", propOrder = {"empresa", "codigoalfanum9"})
public class AGRUPADORRIESGOSType {
    @XmlElement(name = "CODIGO_ALFANUM_9", required = true)
    protected String codigoalfanum9;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODIGOALFANUM9() {
        return this.codigoalfanum9;
    }

    public void setCODIGOALFANUM9(String str) {
        this.codigoalfanum9 = str;
    }
}
