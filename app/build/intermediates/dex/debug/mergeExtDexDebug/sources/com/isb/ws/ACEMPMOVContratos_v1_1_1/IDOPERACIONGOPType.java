package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_OPERACION_GOP_Type", propOrder = {"empresa", "numopergop"})
public class IDOPERACIONGOPType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "NUM_OPER_GOP", required = true)
    protected BigInteger numopergop;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public BigInteger getNUMOPERGOP() {
        return this.numopergop;
    }

    public void setNUMOPERGOP(BigInteger bigInteger) {
        this.numopergop = bigInteger;
    }
}
