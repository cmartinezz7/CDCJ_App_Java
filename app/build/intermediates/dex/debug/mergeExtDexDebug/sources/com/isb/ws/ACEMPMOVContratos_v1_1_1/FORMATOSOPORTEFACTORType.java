package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FORMATO_SOPORTE_FACTOR_Type", propOrder = {"empresaconcodalfanum2", "codalfanum2"})
public class FORMATOSOPORTEFACTORType {
    @XmlElement(name = "COD_ALFANUM2", required = true)
    protected String codalfanum2;
    @XmlElement(name = "EMPRESA_CON_COD_ALFANUM2", required = true)
    protected TIPSOPORTERECEPFACTORType empresaconcodalfanum2;

    public TIPSOPORTERECEPFACTORType getEMPRESACONCODALFANUM2() {
        return this.empresaconcodalfanum2;
    }

    public void setEMPRESACONCODALFANUM2(TIPSOPORTERECEPFACTORType tIPSOPORTERECEPFACTORType) {
        this.empresaconcodalfanum2 = tIPSOPORTERECEPFACTORType;
    }

    public String getCODALFANUM2() {
        return this.codalfanum2;
    }

    public void setCODALFANUM2(String str) {
        this.codalfanum2 = str;
    }
}
