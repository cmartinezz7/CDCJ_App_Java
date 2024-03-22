package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTRAPARTIDA_CONSOLIDAC_Type", propOrder = {"empresaalfanum3", "codalfanum3"})
public class CONTRAPARTIDACONSOLIDACType {
    @XmlElement(name = "COD_ALFANUM_3", required = true)
    protected String codalfanum3;
    @XmlElement(name = "EMPRESA_ALFANUM_3", required = true)
    protected ENTORNOCONSOLIDACFINANType empresaalfanum3;

    public ENTORNOCONSOLIDACFINANType getEMPRESAALFANUM3() {
        return this.empresaalfanum3;
    }

    public void setEMPRESAALFANUM3(ENTORNOCONSOLIDACFINANType eNTORNOCONSOLIDACFINANType) {
        this.empresaalfanum3 = eNTORNOCONSOLIDACFINANType;
    }

    public String getCODALFANUM3() {
        return this.codalfanum3;
    }

    public void setCODALFANUM3(String str) {
        this.codalfanum3 = str;
    }
}
