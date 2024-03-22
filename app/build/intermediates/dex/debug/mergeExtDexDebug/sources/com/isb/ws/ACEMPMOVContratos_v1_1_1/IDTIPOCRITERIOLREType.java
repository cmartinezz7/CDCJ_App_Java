package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_TIPO_CRITERIO_LRE_Type", propOrder = {"idtipoaplicacionlre", "codcriterio"})
public class IDTIPOCRITERIOLREType {
    @XmlElement(name = "COD_CRITERIO", required = true)
    protected String codcriterio;
    @XmlElement(name = "ID_TIPO_APLICACION_LRE", required = true)
    protected IDTIPOAPLICACIONLREType idtipoaplicacionlre;

    public IDTIPOAPLICACIONLREType getIDTIPOAPLICACIONLRE() {
        return this.idtipoaplicacionlre;
    }

    public void setIDTIPOAPLICACIONLRE(IDTIPOAPLICACIONLREType iDTIPOAPLICACIONLREType) {
        this.idtipoaplicacionlre = iDTIPOAPLICACIONLREType;
    }

    public String getCODCRITERIO() {
        return this.codcriterio;
    }

    public void setCODCRITERIO(String str) {
        this.codcriterio = str;
    }
}
