package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_TECSTATUS_COBMAS_Type", propOrder = {"idappstatuscobmas", "codestado"})
public class IDTECSTATUSCOBMASType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_ESTADO")
    protected int codestado;
    @XmlElement(name = "ID_APPSTATUS_COBMAS", required = true)
    protected IDAPPSTATUSCOBMASType idappstatuscobmas;

    public IDAPPSTATUSCOBMASType getIDAPPSTATUSCOBMAS() {
        return this.idappstatuscobmas;
    }

    public void setIDAPPSTATUSCOBMAS(IDAPPSTATUSCOBMASType iDAPPSTATUSCOBMASType) {
        this.idappstatuscobmas = iDAPPSTATUSCOBMASType;
    }

    public int getCODESTADO() {
        return this.codestado;
    }

    public void setCODESTADO(int i) {
        this.codestado = i;
    }
}
