package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CAUSA_INTENTO_OBM_Type", propOrder = {"estadointentoobm", "codcausa"})
public class CAUSAINTENTOOBMType {
    @XmlElement(name = "COD_CAUSA", required = true)
    protected String codcausa;
    @XmlElement(name = "ESTADO_INTENTO_OBM", required = true)
    protected ESTADOINTENTOOBMType estadointentoobm;

    public ESTADOINTENTOOBMType getESTADOINTENTOOBM() {
        return this.estadointentoobm;
    }

    public void setESTADOINTENTOOBM(ESTADOINTENTOOBMType eSTADOINTENTOOBMType) {
        this.estadointentoobm = eSTADOINTENTOOBMType;
    }

    public String getCODCAUSA() {
        return this.codcausa;
    }

    public void setCODCAUSA(String str) {
        this.codcausa = str;
    }
}
