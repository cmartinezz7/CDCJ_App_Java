package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_ACUERDO_MENSAJE_ACBCO_Type", propOrder = {"acuerdo", "mensaje", "sentido"})
public class IDACUERDOMENSAJEACBCOType {
    @XmlElement(name = "ACUERDO", required = true)
    protected IDACUERDOACBCOType acuerdo;
    @XmlElement(name = "MENSAJE", required = true)
    protected String mensaje;
    @XmlElement(name = "SENTIDO", required = true)
    protected String sentido;

    public IDACUERDOACBCOType getACUERDO() {
        return this.acuerdo;
    }

    public void setACUERDO(IDACUERDOACBCOType iDACUERDOACBCOType) {
        this.acuerdo = iDACUERDOACBCOType;
    }

    public String getMENSAJE() {
        return this.mensaje;
    }

    public void setMENSAJE(String str) {
        this.mensaje = str;
    }

    public String getSENTIDO() {
        return this.sentido;
    }

    public void setSENTIDO(String str) {
        this.sentido = str;
    }
}
