package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACTIVIDAD_PN_Type", propOrder = {"subfasepn", "codigoalfanum"})
public class ACTIVIDADPNType {
    @XmlElement(name = "CODIGO_ALFANUM", required = true)
    protected String codigoalfanum;
    @XmlElement(name = "SUBFASE_PN", required = true)
    protected SUBFASEPNType subfasepn;

    public SUBFASEPNType getSUBFASEPN() {
        return this.subfasepn;
    }

    public void setSUBFASEPN(SUBFASEPNType sUBFASEPNType) {
        this.subfasepn = sUBFASEPNType;
    }

    public String getCODIGOALFANUM() {
        return this.codigoalfanum;
    }

    public void setCODIGOALFANUM(String str) {
        this.codigoalfanum = str;
    }
}
