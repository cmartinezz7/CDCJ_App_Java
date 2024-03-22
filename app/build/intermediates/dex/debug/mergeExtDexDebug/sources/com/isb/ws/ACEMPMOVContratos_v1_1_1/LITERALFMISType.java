package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LITERAL_FMIS_Type", propOrder = {"aplicacionfmis", "codliteral"})
public class LITERALFMISType {
    @XmlElement(name = "APLICACION_FMIS", required = true)
    protected String aplicacionfmis;
    @XmlElement(name = "COD_LITERAL", required = true)
    protected String codliteral;

    public String getAPLICACIONFMIS() {
        return this.aplicacionfmis;
    }

    public void setAPLICACIONFMIS(String str) {
        this.aplicacionfmis = str;
    }

    public String getCODLITERAL() {
        return this.codliteral;
    }

    public void setCODLITERAL(String str) {
        this.codliteral = str;
    }
}
