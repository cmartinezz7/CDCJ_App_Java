package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHEQUE_EXTERNO_Type", propOrder = {"cuentachequeext", "numerodecheque"})
public class CHEQUEEXTERNOType {
    @XmlElement(name = "CUENTA_CHEQUE_EXT", required = true)
    protected CONTRATOPRESEN6MAS8EXTType cuentachequeext;
    @XmlElement(name = "NUMERO_DE_CHEQUE", required = true)
    protected String numerodecheque;

    public CONTRATOPRESEN6MAS8EXTType getCUENTACHEQUEEXT() {
        return this.cuentachequeext;
    }

    public void setCUENTACHEQUEEXT(CONTRATOPRESEN6MAS8EXTType cONTRATOPRESEN6MAS8EXTType) {
        this.cuentachequeext = cONTRATOPRESEN6MAS8EXTType;
    }

    public String getNUMERODECHEQUE() {
        return this.numerodecheque;
    }

    public void setNUMERODECHEQUE(String str) {
        this.numerodecheque = str;
    }
}
