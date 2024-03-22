package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_OBJETO_FABRICA_SEG_Type", propOrder = {"companiadeseguros", "tipoobjeto", "descripciontipoobjeto", "subtipoobjeto"})
public class TIPOOBJETOFABRICASEGType {
    @XmlElement(name = "COMPANIA_DE_SEGUROS", required = true)
    protected String companiadeseguros;
    @XmlElement(name = "DESCRIPCION_TIPO_OBJETO", required = true)
    protected String descripciontipoobjeto;
    @XmlElement(name = "SUBTIPO_OBJETO", required = true)
    protected String subtipoobjeto;
    @XmlElement(name = "TIPO_OBJETO", required = true)
    protected String tipoobjeto;

    public String getCOMPANIADESEGUROS() {
        return this.companiadeseguros;
    }

    public void setCOMPANIADESEGUROS(String str) {
        this.companiadeseguros = str;
    }

    public String getTIPOOBJETO() {
        return this.tipoobjeto;
    }

    public void setTIPOOBJETO(String str) {
        this.tipoobjeto = str;
    }

    public String getDESCRIPCIONTIPOOBJETO() {
        return this.descripciontipoobjeto;
    }

    public void setDESCRIPCIONTIPOOBJETO(String str) {
        this.descripciontipoobjeto = str;
    }

    public String getSUBTIPOOBJETO() {
        return this.subtipoobjeto;
    }

    public void setSUBTIPOOBJETO(String str) {
        this.subtipoobjeto = str;
    }
}
