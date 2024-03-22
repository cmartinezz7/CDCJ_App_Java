package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ENSAMBLADO_AHGECO_Type", propOrder = {"codbwproj", "codassembly"})
public class ENSAMBLADOAHGECOType {
    @XmlElement(name = "COD_ASSEMBLY", required = true)
    protected String codassembly;
    @XmlElement(name = "COD_BW_PROJ", required = true)
    protected String codbwproj;

    public String getCODBWPROJ() {
        return this.codbwproj;
    }

    public void setCODBWPROJ(String str) {
        this.codbwproj = str;
    }

    public String getCODASSEMBLY() {
        return this.codassembly;
    }

    public void setCODASSEMBLY(String str) {
        this.codassembly = str;
    }
}
