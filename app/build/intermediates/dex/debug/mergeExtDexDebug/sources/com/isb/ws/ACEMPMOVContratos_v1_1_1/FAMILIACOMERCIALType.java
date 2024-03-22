package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FAMILIA_COMERCIAL_Type", propOrder = {"tipofamiliacomercial", "codfamiliacomercial"})
public class FAMILIACOMERCIALType {
    @XmlElement(name = "COD_FAMILIA_COMERCIAL", required = true)
    protected String codfamiliacomercial;
    @XmlElement(name = "TIPO_FAMILIA_COMERCIAL", required = true)
    protected TIPOFAMILIACOMERCIALType tipofamiliacomercial;

    public TIPOFAMILIACOMERCIALType getTIPOFAMILIACOMERCIAL() {
        return this.tipofamiliacomercial;
    }

    public void setTIPOFAMILIACOMERCIAL(TIPOFAMILIACOMERCIALType tIPOFAMILIACOMERCIALType) {
        this.tipofamiliacomercial = tIPOFAMILIACOMERCIALType;
    }

    public String getCODFAMILIACOMERCIAL() {
        return this.codfamiliacomercial;
    }

    public void setCODFAMILIACOMERCIAL(String str) {
        this.codfamiliacomercial = str;
    }
}
