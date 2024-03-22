package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REG_INTER_OTT_Type", propOrder = {"interfaseott", "secreginterfase"})
public class REGINTEROTTType {
    @XmlElement(name = "INTERFASE_OTT", required = true)
    protected INTERFASEOTTType interfaseott;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "SEC_REG_INTERFASE")
    protected int secreginterfase;

    public INTERFASEOTTType getINTERFASEOTT() {
        return this.interfaseott;
    }

    public void setINTERFASEOTT(INTERFASEOTTType iNTERFASEOTTType) {
        this.interfaseott = iNTERFASEOTTType;
    }

    public int getSECREGINTERFASE() {
        return this.secreginterfase;
    }

    public void setSECREGINTERFASE(int i) {
        this.secreginterfase = i;
    }
}
