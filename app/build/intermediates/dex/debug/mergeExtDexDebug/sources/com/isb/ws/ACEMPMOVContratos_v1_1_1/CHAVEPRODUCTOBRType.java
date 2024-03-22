package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHAVE_PRODUCTO_BR_Type", propOrder = {"codigoalfanum2", "codigoalfanum4"})
public class CHAVEPRODUCTOBRType {
    @XmlElement(name = "CODIGO_ALFANUM_2", required = true)
    protected String codigoalfanum2;
    @XmlElement(name = "CODIGO_ALFANUM_4", required = true)
    protected String codigoalfanum4;

    public String getCODIGOALFANUM2() {
        return this.codigoalfanum2;
    }

    public void setCODIGOALFANUM2(String str) {
        this.codigoalfanum2 = str;
    }

    public String getCODIGOALFANUM4() {
        return this.codigoalfanum4;
    }

    public void setCODIGOALFANUM4(String str) {
        this.codigoalfanum4 = str;
    }
}
