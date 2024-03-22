package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FRACCION_DIVISA_Type", propOrder = {"divisa", "numsecfraccion"})
public class FRACCIONDIVISAType {
    @XmlElement(name = "DIVISA", required = true)
    protected String divisa;
    @XmlElement(name = "NUM_SEC_FRACCION", required = true)
    protected String numsecfraccion;

    public String getDIVISA() {
        return this.divisa;
    }

    public void setDIVISA(String str) {
        this.divisa = str;
    }

    public String getNUMSECFRACCION() {
        return this.numsecfraccion;
    }

    public void setNUMSECFRACCION(String str) {
        this.numsecfraccion = str;
    }
}
