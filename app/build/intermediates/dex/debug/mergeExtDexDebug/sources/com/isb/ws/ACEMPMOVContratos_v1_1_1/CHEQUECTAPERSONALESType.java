package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHEQUE_CTA_PERSONALES_Type", propOrder = {"contratochequectaper", "numerodecheque"})
public class CHEQUECTAPERSONALESType {
    @XmlElement(name = "CONTRATO_CHEQUE_CTAPER", required = true)
    protected CONTRATOPRESEN6MAS7MAS1Type contratochequectaper;
    @XmlElement(name = "NUMERO_DE_CHEQUE", required = true)
    protected String numerodecheque;

    public CONTRATOPRESEN6MAS7MAS1Type getCONTRATOCHEQUECTAPER() {
        return this.contratochequectaper;
    }

    public void setCONTRATOCHEQUECTAPER(CONTRATOPRESEN6MAS7MAS1Type cONTRATOPRESEN6MAS7MAS1Type) {
        this.contratochequectaper = cONTRATOPRESEN6MAS7MAS1Type;
    }

    public String getNUMERODECHEQUE() {
        return this.numerodecheque;
    }

    public void setNUMERODECHEQUE(String str) {
        this.numerodecheque = str;
    }
}
