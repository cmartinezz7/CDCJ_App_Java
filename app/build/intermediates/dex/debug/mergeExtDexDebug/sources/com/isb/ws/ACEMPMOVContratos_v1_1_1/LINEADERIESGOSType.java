package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LINEA_DE_RIESGOS_Type", propOrder = {"sistemaderiesgos", "nivelderiesgos", "codigodelinea"})
public class LINEADERIESGOSType {
    @XmlElement(name = "CODIGO_DE_LINEA", required = true)
    protected String codigodelinea;
    @XmlElement(name = "NIVEL_DE_RIESGOS", required = true)
    protected String nivelderiesgos;
    @XmlElement(name = "SISTEMA_DE_RIESGOS", required = true)
    protected String sistemaderiesgos;

    public String getSISTEMADERIESGOS() {
        return this.sistemaderiesgos;
    }

    public void setSISTEMADERIESGOS(String str) {
        this.sistemaderiesgos = str;
    }

    public String getNIVELDERIESGOS() {
        return this.nivelderiesgos;
    }

    public void setNIVELDERIESGOS(String str) {
        this.nivelderiesgos = str;
    }

    public String getCODIGODELINEA() {
        return this.codigodelinea;
    }

    public void setCODIGODELINEA(String str) {
        this.codigodelinea = str;
    }
}
