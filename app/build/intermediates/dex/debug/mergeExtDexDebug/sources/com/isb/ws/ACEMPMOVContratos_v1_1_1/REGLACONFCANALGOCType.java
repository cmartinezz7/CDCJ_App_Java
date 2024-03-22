package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REGLA_CONF_CANAL_GOC_Type", propOrder = {"empresa", "codregla", "codigodecanal", "codconfiguracionregla"})
public class REGLACONFCANALGOCType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_CONFIGURACION_REGLA")
    protected int codconfiguracionregla;
    @XmlElement(name = "CODIGO_DE_CANAL", required = true)
    protected String codigodecanal;
    @XmlElement(name = "COD_REGLA", required = true)
    protected String codregla;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODREGLA() {
        return this.codregla;
    }

    public void setCODREGLA(String str) {
        this.codregla = str;
    }

    public String getCODIGODECANAL() {
        return this.codigodecanal;
    }

    public void setCODIGODECANAL(String str) {
        this.codigodecanal = str;
    }

    public int getCODCONFIGURACIONREGLA() {
        return this.codconfiguracionregla;
    }

    public void setCODCONFIGURACIONREGLA(int i) {
        this.codconfiguracionregla = i;
    }
}
