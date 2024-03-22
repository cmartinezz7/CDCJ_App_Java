package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_ELEMENTO_GARANTIAS_Type", propOrder = {"empresa", "codigotipodeelemento", "codigotipodedato"})
public class TIPOELEMENTOGARANTIASType {
    @XmlElement(name = "CODIGO_TIPO_DE_DATO", required = true)
    protected String codigotipodedato;
    @XmlElement(name = "CODIGO_TIPO_DE_ELEMENTO", required = true)
    protected String codigotipodeelemento;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODIGOTIPODEELEMENTO() {
        return this.codigotipodeelemento;
    }

    public void setCODIGOTIPODEELEMENTO(String str) {
        this.codigotipodeelemento = str;
    }

    public String getCODIGOTIPODEDATO() {
        return this.codigotipodedato;
    }

    public void setCODIGOTIPODEDATO(String str) {
        this.codigotipodedato = str;
    }
}
