package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GARANTIA_COMERCIAL_Type", propOrder = {"clase", "tipo", "codigo"})
public class GARANTIACOMERCIALType {
    @XmlElement(name = "CLASE", required = true)
    protected String clase;
    @XmlElement(name = "CODIGO", required = true)
    protected String codigo;
    @XmlElement(name = "TIPO", required = true)
    protected String tipo;

    public String getCLASE() {
        return this.clase;
    }

    public void setCLASE(String str) {
        this.clase = str;
    }

    public String getTIPO() {
        return this.tipo;
    }

    public void setTIPO(String str) {
        this.tipo = str;
    }

    public String getCODIGO() {
        return this.codigo;
    }

    public void setCODIGO(String str) {
        this.codigo = str;
    }
}
