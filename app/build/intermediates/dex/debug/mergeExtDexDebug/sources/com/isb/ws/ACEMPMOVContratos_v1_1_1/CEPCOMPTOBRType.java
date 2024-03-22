package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CEP_COMPTO_BR_Type", propOrder = {"codigoalfanum5", "codigoalfanum3"})
public class CEPCOMPTOBRType {
    @XmlElement(name = "CODIGO_ALFANUM_3", required = true)
    protected String codigoalfanum3;
    @XmlElement(name = "CODIGO_ALFANUM_5", required = true)
    protected String codigoalfanum5;

    public String getCODIGOALFANUM5() {
        return this.codigoalfanum5;
    }

    public void setCODIGOALFANUM5(String str) {
        this.codigoalfanum5 = str;
    }

    public String getCODIGOALFANUM3() {
        return this.codigoalfanum3;
    }

    public void setCODIGOALFANUM3(String str) {
        this.codigoalfanum3 = str;
    }
}
