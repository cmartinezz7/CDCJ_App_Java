package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBCLAS_COMERCIAL_CENTRO_Type", propOrder = {"clascomercialcentro", "codalfanum2"})
public class SUBCLASCOMERCIALCENTROType {
    @XmlElement(name = "CLAS_COMERCIAL_CENTRO", required = true)
    protected String clascomercialcentro;
    @XmlElement(name = "COD_ALFANUM_2", required = true)
    protected String codalfanum2;

    public String getCLASCOMERCIALCENTRO() {
        return this.clascomercialcentro;
    }

    public void setCLASCOMERCIALCENTRO(String str) {
        this.clascomercialcentro = str;
    }

    public String getCODALFANUM2() {
        return this.codalfanum2;
    }

    public void setCODALFANUM2(String str) {
        this.codalfanum2 = str;
    }
}
