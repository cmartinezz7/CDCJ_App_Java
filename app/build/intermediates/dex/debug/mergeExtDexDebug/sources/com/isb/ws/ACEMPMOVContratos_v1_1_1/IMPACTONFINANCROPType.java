package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IMPACTO_NFINANC_ROP_Type", propOrder = {"codalfanum2", "codalfanum3"})
public class IMPACTONFINANCROPType {
    @XmlElement(name = "COD_ALFANUM2", required = true)
    protected String codalfanum2;
    @XmlElement(name = "COD_ALFANUM3", required = true)
    protected String codalfanum3;

    public String getCODALFANUM2() {
        return this.codalfanum2;
    }

    public void setCODALFANUM2(String str) {
        this.codalfanum2 = str;
    }

    public String getCODALFANUM3() {
        return this.codalfanum3;
    }

    public void setCODALFANUM3(String str) {
        this.codalfanum3 = str;
    }
}
