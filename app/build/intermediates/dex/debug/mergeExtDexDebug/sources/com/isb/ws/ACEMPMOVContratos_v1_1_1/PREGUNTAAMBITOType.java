package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PREGUNTA_AMBITO_Type", propOrder = {"ambito", "codigopregunta"})
public class PREGUNTAAMBITOType {
    @XmlElement(name = "AMBITO", required = true)
    protected String ambito;
    @XmlElement(name = "CODIGO_PREGUNTA", required = true)
    protected String codigopregunta;

    public String getAMBITO() {
        return this.ambito;
    }

    public void setAMBITO(String str) {
        this.ambito = str;
    }

    public String getCODIGOPREGUNTA() {
        return this.codigopregunta;
    }

    public void setCODIGOPREGUNTA(String str) {
        this.codigopregunta = str;
    }
}
