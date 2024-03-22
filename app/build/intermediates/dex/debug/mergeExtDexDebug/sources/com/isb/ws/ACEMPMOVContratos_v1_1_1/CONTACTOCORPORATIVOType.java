package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTACTO_CORPORATIVO_Type", propOrder = {"formatocontacto", "contactotransito"})
public class CONTACTOCORPORATIVOType {
    @XmlElement(name = "CONTACTO_TRANSITO", required = true)
    protected String contactotransito;
    @XmlElement(name = "FORMATO_CONTACTO", required = true)
    protected String formatocontacto;

    public String getFORMATOCONTACTO() {
        return this.formatocontacto;
    }

    public void setFORMATOCONTACTO(String str) {
        this.formatocontacto = str;
    }

    public String getCONTACTOTRANSITO() {
        return this.contactotransito;
    }

    public void setCONTACTOTRANSITO(String str) {
        this.contactotransito = str;
    }
}
