package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESTADO_NOF_Type", propOrder = {"idmensajenof", "codestadonof"})
public class ESTADONOFType {
    @XmlElement(name = "COD_ESTADO_NOF", required = true)
    protected String codestadonof;
    @XmlElement(name = "ID_MENSAJE_NOF", required = true)
    protected IDMENSAJENOFType idmensajenof;

    public IDMENSAJENOFType getIDMENSAJENOF() {
        return this.idmensajenof;
    }

    public void setIDMENSAJENOF(IDMENSAJENOFType iDMENSAJENOFType) {
        this.idmensajenof = iDMENSAJENOFType;
    }

    public String getCODESTADONOF() {
        return this.codestadonof;
    }

    public void setCODESTADONOF(String str) {
        this.codestadonof = str;
    }
}
