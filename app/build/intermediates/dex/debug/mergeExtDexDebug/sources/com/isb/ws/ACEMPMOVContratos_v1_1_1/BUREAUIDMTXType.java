package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BUREAUID_MTX_Type", propOrder = {"empresa", "numexpediente"})
public class BUREAUIDMTXType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_EXPEDIENTE")
    protected long numexpediente;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public long getNUMEXPEDIENTE() {
        return this.numexpediente;
    }

    public void setNUMEXPEDIENTE(long j) {
        this.numexpediente = j;
    }
}
