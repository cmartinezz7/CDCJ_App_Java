package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EXPEDIENTE_EEFF_Type", propOrder = {"empresaeeff", "expedienteeeff"})
public class EXPEDIENTEEEFFType {
    @XmlElement(name = "EMPRESA_EEFF", required = true)
    protected String empresaeeff;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "EXPEDIENTE_EEFF")
    protected long expedienteeeff;

    public String getEMPRESAEEFF() {
        return this.empresaeeff;
    }

    public void setEMPRESAEEFF(String str) {
        this.empresaeeff = str;
    }

    public long getEXPEDIENTEEEFF() {
        return this.expedienteeeff;
    }

    public void setEXPEDIENTEEEFF(long j) {
        this.expedienteeeff = j;
    }
}
