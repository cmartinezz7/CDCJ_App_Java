package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PARAM_SERVICIO_AHEBMG_Type", propOrder = {"servicioahebmg", "codalfanum2"})
public class PARAMSERVICIOAHEBMGType {
    @XmlElement(name = "COD_ALFANUM_2", required = true)
    protected String codalfanum2;
    @XmlElement(name = "SERVICIO_AHEBMG", required = true)
    protected SERVICIOAHEBMGType servicioahebmg;

    public SERVICIOAHEBMGType getSERVICIOAHEBMG() {
        return this.servicioahebmg;
    }

    public void setSERVICIOAHEBMG(SERVICIOAHEBMGType sERVICIOAHEBMGType) {
        this.servicioahebmg = sERVICIOAHEBMGType;
    }

    public String getCODALFANUM2() {
        return this.codalfanum2;
    }

    public void setCODALFANUM2(String str) {
        this.codalfanum2 = str;
    }
}
