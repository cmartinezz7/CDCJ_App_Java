package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OPCION_MENU_FMIS_Type", propOrder = {"aplicacionfmis", "empresafmis", "codigoopcionmenufmis"})
public class OPCIONMENUFMISType {
    @XmlElement(name = "APLICACION_FMIS", required = true)
    protected String aplicacionfmis;
    @XmlElement(name = "CODIGO_OPCION_MENU_FMIS", required = true)
    protected String codigoopcionmenufmis;
    @XmlElement(name = "EMPRESA_FMIS", required = true)
    protected String empresafmis;

    public String getAPLICACIONFMIS() {
        return this.aplicacionfmis;
    }

    public void setAPLICACIONFMIS(String str) {
        this.aplicacionfmis = str;
    }

    public String getEMPRESAFMIS() {
        return this.empresafmis;
    }

    public void setEMPRESAFMIS(String str) {
        this.empresafmis = str;
    }

    public String getCODIGOOPCIONMENUFMIS() {
        return this.codigoopcionmenufmis;
    }

    public void setCODIGOOPCIONMENUFMIS(String str) {
        this.codigoopcionmenufmis = str;
    }
}
