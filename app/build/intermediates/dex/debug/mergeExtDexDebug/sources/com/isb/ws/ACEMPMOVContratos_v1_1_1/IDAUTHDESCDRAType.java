package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_AUTH_DESC_DRA_Type", propOrder = {"idauthtypedra", "codauthdesc"})
public class IDAUTHDESCDRAType {
    @XmlElement(name = "COD_AUTH_DESC", required = true)
    protected String codauthdesc;
    @XmlElement(name = "ID_AUTH_TYPE_DRA", required = true)
    protected IDAUTHTYPEDRAType idauthtypedra;

    public IDAUTHTYPEDRAType getIDAUTHTYPEDRA() {
        return this.idauthtypedra;
    }

    public void setIDAUTHTYPEDRA(IDAUTHTYPEDRAType iDAUTHTYPEDRAType) {
        this.idauthtypedra = iDAUTHTYPEDRAType;
    }

    public String getCODAUTHDESC() {
        return this.codauthdesc;
    }

    public void setCODAUTHDESC(String str) {
        this.codauthdesc = str;
    }
}
