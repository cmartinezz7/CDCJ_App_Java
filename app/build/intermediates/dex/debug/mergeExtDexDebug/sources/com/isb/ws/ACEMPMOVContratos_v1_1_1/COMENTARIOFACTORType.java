package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COMENTARIO_FACTOR_Type", propOrder = {"empresaconcodalfanum2", "codalfanum2"})
public class COMENTARIOFACTORType {
    @XmlElement(name = "COD_ALFANUM2", required = true)
    protected String codalfanum2;
    @XmlElement(name = "EMPRESA_CON_COD_ALFANUM2", required = true)
    protected TIPOCOMENTARIOFACTORType empresaconcodalfanum2;

    public TIPOCOMENTARIOFACTORType getEMPRESACONCODALFANUM2() {
        return this.empresaconcodalfanum2;
    }

    public void setEMPRESACONCODALFANUM2(TIPOCOMENTARIOFACTORType tIPOCOMENTARIOFACTORType) {
        this.empresaconcodalfanum2 = tIPOCOMENTARIOFACTORType;
    }

    public String getCODALFANUM2() {
        return this.codalfanum2;
    }

    public void setCODALFANUM2(String str) {
        this.codalfanum2 = str;
    }
}
