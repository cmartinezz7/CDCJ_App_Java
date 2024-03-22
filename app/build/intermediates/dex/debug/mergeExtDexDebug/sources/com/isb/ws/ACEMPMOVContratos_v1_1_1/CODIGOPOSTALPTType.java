package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CODIGO_POSTAL_PT_Type", propOrder = {"codzonapostal", "codcomplementopostal"})
public class CODIGOPOSTALPTType {
    @XmlElement(name = "COD_COMPLEMENTO_POSTAL", required = true)
    protected String codcomplementopostal;
    @XmlElement(name = "COD_ZONA_POSTAL", required = true)
    protected String codzonapostal;

    public String getCODZONAPOSTAL() {
        return this.codzonapostal;
    }

    public void setCODZONAPOSTAL(String str) {
        this.codzonapostal = str;
    }

    public String getCODCOMPLEMENTOPOSTAL() {
        return this.codcomplementopostal;
    }

    public void setCODCOMPLEMENTOPOSTAL(String str) {
        this.codcomplementopostal = str;
    }
}
