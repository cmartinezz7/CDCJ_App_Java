package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_FAMILIA_COMERCIAL_Type", propOrder = {"clasefamiliacomercial", "codtipfamiliacomercial"})
public class TIPOFAMILIACOMERCIALType {
    @XmlElement(name = "CLASE_FAMILIA_COMERCIAL", required = true)
    protected CLASEFAMILIACOMERCIALType clasefamiliacomercial;
    @XmlElement(name = "COD_TIP_FAMILIA_COMERCIAL", required = true)
    protected String codtipfamiliacomercial;

    public CLASEFAMILIACOMERCIALType getCLASEFAMILIACOMERCIAL() {
        return this.clasefamiliacomercial;
    }

    public void setCLASEFAMILIACOMERCIAL(CLASEFAMILIACOMERCIALType cLASEFAMILIACOMERCIALType) {
        this.clasefamiliacomercial = cLASEFAMILIACOMERCIALType;
    }

    public String getCODTIPFAMILIACOMERCIAL() {
        return this.codtipfamiliacomercial;
    }

    public void setCODTIPFAMILIACOMERCIAL(String str) {
        this.codtipfamiliacomercial = str;
    }
}
