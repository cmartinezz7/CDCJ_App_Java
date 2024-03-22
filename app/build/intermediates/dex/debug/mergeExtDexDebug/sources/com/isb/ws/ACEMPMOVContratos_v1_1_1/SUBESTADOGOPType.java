package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBESTADO_GOP_Type", propOrder = {"estadogop", "codsubestadogop"})
public class SUBESTADOGOPType {
    @XmlElement(name = "COD_SUBESTADO_GOP", required = true)
    protected String codsubestadogop;
    @XmlElement(name = "ESTADO_GOP", required = true)
    protected ESTADOGOPType estadogop;

    public ESTADOGOPType getESTADOGOP() {
        return this.estadogop;
    }

    public void setESTADOGOP(ESTADOGOPType eSTADOGOPType) {
        this.estadogop = eSTADOGOPType;
    }

    public String getCODSUBESTADOGOP() {
        return this.codsubestadogop;
    }

    public void setCODSUBESTADOGOP(String str) {
        this.codsubestadogop = str;
    }
}
