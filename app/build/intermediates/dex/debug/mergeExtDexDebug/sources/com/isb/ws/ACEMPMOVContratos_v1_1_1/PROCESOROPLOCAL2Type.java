package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PROCESO_ROP_LOCAL_2_Type", propOrder = {"empresaconcodalfanum2", "codalfanum2"})
public class PROCESOROPLOCAL2Type {
    @XmlElement(name = "COD_ALFANUM2", required = true)
    protected String codalfanum2;
    @XmlElement(name = "EMPRESA_CON_COD_ALFANUM2", required = true)
    protected PROCESOROPLOCAL1Type empresaconcodalfanum2;

    public PROCESOROPLOCAL1Type getEMPRESACONCODALFANUM2() {
        return this.empresaconcodalfanum2;
    }

    public void setEMPRESACONCODALFANUM2(PROCESOROPLOCAL1Type pROCESOROPLOCAL1Type) {
        this.empresaconcodalfanum2 = pROCESOROPLOCAL1Type;
    }

    public String getCODALFANUM2() {
        return this.codalfanum2;
    }

    public void setCODALFANUM2(String str) {
        this.codalfanum2 = str;
    }
}
