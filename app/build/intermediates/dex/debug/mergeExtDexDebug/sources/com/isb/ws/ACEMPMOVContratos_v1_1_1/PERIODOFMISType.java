package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PERIODO_FMIS_Type", propOrder = {"aplicacionfmis", "codigoperiodo"})
public class PERIODOFMISType {
    @XmlElement(name = "APLICACION_FMIS", required = true)
    protected String aplicacionfmis;
    @XmlElement(name = "CODIGO_PERIODO", required = true)
    protected String codigoperiodo;

    public String getAPLICACIONFMIS() {
        return this.aplicacionfmis;
    }

    public void setAPLICACIONFMIS(String str) {
        this.aplicacionfmis = str;
    }

    public String getCODIGOPERIODO() {
        return this.codigoperiodo;
    }

    public void setCODIGOPERIODO(String str) {
        this.codigoperiodo = str;
    }
}
