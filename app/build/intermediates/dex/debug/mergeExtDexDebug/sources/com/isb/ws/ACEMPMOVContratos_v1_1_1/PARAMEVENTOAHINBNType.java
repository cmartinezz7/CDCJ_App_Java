package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PARAM_EVENTO_AHINBN_Type", propOrder = {"eventoahebmg", "codalfanum2"})
public class PARAMEVENTOAHINBNType {
    @XmlElement(name = "COD_ALFANUM_2", required = true)
    protected String codalfanum2;
    @XmlElement(name = "EVENTO_AHEBMG", required = true)
    protected EVENTOAHINBNType eventoahebmg;

    public EVENTOAHINBNType getEVENTOAHEBMG() {
        return this.eventoahebmg;
    }

    public void setEVENTOAHEBMG(EVENTOAHINBNType eVENTOAHINBNType) {
        this.eventoahebmg = eVENTOAHINBNType;
    }

    public String getCODALFANUM2() {
        return this.codalfanum2;
    }

    public void setCODALFANUM2(String str) {
        this.codalfanum2 = str;
    }
}
