package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APLICACION_EOGHCO_Type", propOrder = {"codemp", "codcanal", "codaplicacion"})
public class APLICACIONEOGHCOType {
    @XmlElement(name = "COD_APLICACION", required = true)
    protected String codaplicacion;
    @XmlElement(name = "COD_CANAL", required = true)
    protected String codcanal;
    @XmlElement(name = "COD_EMP", required = true)
    protected String codemp;

    public String getCODEMP() {
        return this.codemp;
    }

    public void setCODEMP(String str) {
        this.codemp = str;
    }

    public String getCODCANAL() {
        return this.codcanal;
    }

    public void setCODCANAL(String str) {
        this.codcanal = str;
    }

    public String getCODAPLICACION() {
        return this.codaplicacion;
    }

    public void setCODAPLICACION(String str) {
        this.codaplicacion = str;
    }
}
