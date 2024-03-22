package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BUREAU_NAME_RESP_MTX_Type", propOrder = {"bureauidmtx", "numpersonacliente", "bureaunamemtx"})
public class BUREAUNAMERESPMTXType {
    @XmlElement(name = "BUREAUID_MTX", required = true)
    protected BUREAUIDMTXType bureauidmtx;
    @XmlElement(name = "BUREAU_NAME_MTX", required = true)
    protected String bureaunamemtx;
    @XmlElement(name = "NUM_PERSONA_CLIENTE", required = true)
    protected NUMPERSONACLIENTEType numpersonacliente;

    public BUREAUIDMTXType getBUREAUIDMTX() {
        return this.bureauidmtx;
    }

    public void setBUREAUIDMTX(BUREAUIDMTXType bUREAUIDMTXType) {
        this.bureauidmtx = bUREAUIDMTXType;
    }

    public NUMPERSONACLIENTEType getNUMPERSONACLIENTE() {
        return this.numpersonacliente;
    }

    public void setNUMPERSONACLIENTE(NUMPERSONACLIENTEType nUMPERSONACLIENTEType) {
        this.numpersonacliente = nUMPERSONACLIENTEType;
    }

    public String getBUREAUNAMEMTX() {
        return this.bureaunamemtx;
    }

    public void setBUREAUNAMEMTX(String str) {
        this.bureaunamemtx = str;
    }
}
