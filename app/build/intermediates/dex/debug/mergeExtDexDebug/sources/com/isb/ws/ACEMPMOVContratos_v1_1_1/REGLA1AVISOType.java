package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REGLA_1_AVISO_Type", propOrder = {"codcircuitoaviso", "codopcion1"})
public class REGLA1AVISOType {
    @XmlElement(name = "COD_CIRCUITO_AVISO", required = true)
    protected String codcircuitoaviso;
    @XmlElement(name = "COD_OPCION_1", required = true)
    protected String codopcion1;

    public String getCODCIRCUITOAVISO() {
        return this.codcircuitoaviso;
    }

    public void setCODCIRCUITOAVISO(String str) {
        this.codcircuitoaviso = str;
    }

    public String getCODOPCION1() {
        return this.codopcion1;
    }

    public void setCODOPCION1(String str) {
        this.codopcion1 = str;
    }
}
