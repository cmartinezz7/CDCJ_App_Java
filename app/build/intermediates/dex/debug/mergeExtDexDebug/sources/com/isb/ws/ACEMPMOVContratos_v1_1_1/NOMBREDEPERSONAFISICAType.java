package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NOMBRE_DE_PERSONA_FISICA_Type", propOrder = {"nombre", "partprimerapellido", "primerapellido", "partsegundoapellido", "segundoapellido"})
public class NOMBREDEPERSONAFISICAType {
    @XmlElement(name = "NOMBRE", required = true)
    protected String nombre;
    @XmlElement(name = "PART_PRIMER_APELLIDO", required = true)
    protected String partprimerapellido;
    @XmlElement(name = "PART_SEGUNDO_APELLIDO", required = true)
    protected String partsegundoapellido;
    @XmlElement(name = "PRIMER_APELLIDO", required = true)
    protected String primerapellido;
    @XmlElement(name = "SEGUNDO_APELLIDO", required = true)
    protected String segundoapellido;

    public String getNOMBRE() {
        return this.nombre;
    }

    public void setNOMBRE(String str) {
        this.nombre = str;
    }

    public String getPARTPRIMERAPELLIDO() {
        return this.partprimerapellido;
    }

    public void setPARTPRIMERAPELLIDO(String str) {
        this.partprimerapellido = str;
    }

    public String getPRIMERAPELLIDO() {
        return this.primerapellido;
    }

    public void setPRIMERAPELLIDO(String str) {
        this.primerapellido = str;
    }

    public String getPARTSEGUNDOAPELLIDO() {
        return this.partsegundoapellido;
    }

    public void setPARTSEGUNDOAPELLIDO(String str) {
        this.partsegundoapellido = str;
    }

    public String getSEGUNDOAPELLIDO() {
        return this.segundoapellido;
    }

    public void setSEGUNDOAPELLIDO(String str) {
        this.segundoapellido = str;
    }
}
