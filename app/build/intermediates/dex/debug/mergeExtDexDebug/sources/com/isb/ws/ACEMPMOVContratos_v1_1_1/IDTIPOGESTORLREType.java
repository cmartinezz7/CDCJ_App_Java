package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_TIPO_GESTOR_LRE_Type", propOrder = {"idtipoaplicacionlre", "codtipogestion"})
public class IDTIPOGESTORLREType {
    @XmlElement(name = "COD_TIPO_GESTION", required = true)
    protected String codtipogestion;
    @XmlElement(name = "ID_TIPO_APLICACION_LRE", required = true)
    protected IDTIPOAPLICACIONLREType idtipoaplicacionlre;

    public IDTIPOAPLICACIONLREType getIDTIPOAPLICACIONLRE() {
        return this.idtipoaplicacionlre;
    }

    public void setIDTIPOAPLICACIONLRE(IDTIPOAPLICACIONLREType iDTIPOAPLICACIONLREType) {
        this.idtipoaplicacionlre = iDTIPOAPLICACIONLREType;
    }

    public String getCODTIPOGESTION() {
        return this.codtipogestion;
    }

    public void setCODTIPOGESTION(String str) {
        this.codtipogestion = str;
    }
}
