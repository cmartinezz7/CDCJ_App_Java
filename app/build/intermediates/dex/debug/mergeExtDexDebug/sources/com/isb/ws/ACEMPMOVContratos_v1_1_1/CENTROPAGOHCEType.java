package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CENTRO_PAGO_HCE_Type", propOrder = {"centro", "codalfanum2"})
public class CENTROPAGOHCEType {
    @XmlElement(name = "CENTRO", required = true)
    protected String centro;
    @XmlElement(name = "COD_ALFANUM_2", required = true)
    protected String codalfanum2;

    public String getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(String str) {
        this.centro = str;
    }

    public String getCODALFANUM2() {
        return this.codalfanum2;
    }

    public void setCODALFANUM2(String str) {
        this.codalfanum2 = str;
    }
}
