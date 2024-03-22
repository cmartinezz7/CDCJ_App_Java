package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LEGISLAC_JERARQUIA_JUSNUE_Type", propOrder = {"codigoalfanum2", "codigoalfanum20"})
public class LEGISLACJERARQUIAJUSNUEType {
    @XmlElement(name = "CODIGO_ALFANUM_2", required = true)
    protected String codigoalfanum2;
    @XmlElement(name = "CODIGO_ALFANUM_20", required = true)
    protected String codigoalfanum20;

    public String getCODIGOALFANUM2() {
        return this.codigoalfanum2;
    }

    public void setCODIGOALFANUM2(String str) {
        this.codigoalfanum2 = str;
    }

    public String getCODIGOALFANUM20() {
        return this.codigoalfanum20;
    }

    public void setCODIGOALFANUM20(String str) {
        this.codigoalfanum20 = str;
    }
}
