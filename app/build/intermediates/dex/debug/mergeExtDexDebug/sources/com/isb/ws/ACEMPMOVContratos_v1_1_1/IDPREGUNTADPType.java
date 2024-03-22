package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_PREGUNTA_DP_Type", propOrder = {"idformulariodp", "codpreguntadp"})
public class IDPREGUNTADPType {
    @XmlElement(name = "COD_PREGUNTA_DP", required = true)
    protected String codpreguntadp;
    @XmlElement(name = "ID_FORMULARIO_DP", required = true)
    protected IDFORMULARIODPType idformulariodp;

    public IDFORMULARIODPType getIDFORMULARIODP() {
        return this.idformulariodp;
    }

    public void setIDFORMULARIODP(IDFORMULARIODPType iDFORMULARIODPType) {
        this.idformulariodp = iDFORMULARIODPType;
    }

    public String getCODPREGUNTADP() {
        return this.codpreguntadp;
    }

    public void setCODPREGUNTADP(String str) {
        this.codpreguntadp = str;
    }
}
