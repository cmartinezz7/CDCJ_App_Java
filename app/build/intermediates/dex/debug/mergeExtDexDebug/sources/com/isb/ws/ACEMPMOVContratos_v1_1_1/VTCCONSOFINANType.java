package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VTC_CONSO_FINAN_Type", propOrder = {"periodoconsolidacfinan", "codsociedad", "codigoajuste", "codsociedadparticipada", "codsociedadtenedora"})
public class VTCCONSOFINANType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_AJUSTE")
    protected int codigoajuste;
    @XmlElement(name = "COD_SOCIEDAD", required = true)
    protected String codsociedad;
    @XmlElement(name = "COD_SOCIEDAD_PARTICIPADA", required = true)
    protected String codsociedadparticipada;
    @XmlElement(name = "COD_SOCIEDAD_TENEDORA", required = true)
    protected String codsociedadtenedora;
    @XmlElement(name = "PERIODO_CONSOLIDAC_FINAN", required = true)
    protected PERIODOCONSOLIDACFINANType periodoconsolidacfinan;

    public PERIODOCONSOLIDACFINANType getPERIODOCONSOLIDACFINAN() {
        return this.periodoconsolidacfinan;
    }

    public void setPERIODOCONSOLIDACFINAN(PERIODOCONSOLIDACFINANType pERIODOCONSOLIDACFINANType) {
        this.periodoconsolidacfinan = pERIODOCONSOLIDACFINANType;
    }

    public String getCODSOCIEDAD() {
        return this.codsociedad;
    }

    public void setCODSOCIEDAD(String str) {
        this.codsociedad = str;
    }

    public int getCODIGOAJUSTE() {
        return this.codigoajuste;
    }

    public void setCODIGOAJUSTE(int i) {
        this.codigoajuste = i;
    }

    public String getCODSOCIEDADPARTICIPADA() {
        return this.codsociedadparticipada;
    }

    public void setCODSOCIEDADPARTICIPADA(String str) {
        this.codsociedadparticipada = str;
    }

    public String getCODSOCIEDADTENEDORA() {
        return this.codsociedadtenedora;
    }

    public void setCODSOCIEDADTENEDORA(String str) {
        this.codsociedadtenedora = str;
    }
}
