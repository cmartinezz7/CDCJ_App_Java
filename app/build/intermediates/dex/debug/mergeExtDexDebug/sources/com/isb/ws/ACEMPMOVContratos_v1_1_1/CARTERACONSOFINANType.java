package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CARTERA_CONSO_FINAN_Type", propOrder = {"periodoconsolidacfinan", "codsociedadaccionista", "codsociedadparticipada", "codtipocartera", "codigoemisorpartenon"})
public class CARTERACONSOFINANType {
    @XmlElement(name = "CODIGO_EMISOR_PARTENON", required = true)
    protected String codigoemisorpartenon;
    @XmlElement(name = "COD_SOCIEDAD_ACCIONISTA", required = true)
    protected String codsociedadaccionista;
    @XmlElement(name = "COD_SOCIEDAD_PARTICIPADA", required = true)
    protected String codsociedadparticipada;
    @XmlElement(name = "COD_TIPO_CARTERA", required = true)
    protected String codtipocartera;
    @XmlElement(name = "PERIODO_CONSOLIDAC_FINAN", required = true)
    protected PERIODOCONSOLIDACFINANType periodoconsolidacfinan;

    public PERIODOCONSOLIDACFINANType getPERIODOCONSOLIDACFINAN() {
        return this.periodoconsolidacfinan;
    }

    public void setPERIODOCONSOLIDACFINAN(PERIODOCONSOLIDACFINANType pERIODOCONSOLIDACFINANType) {
        this.periodoconsolidacfinan = pERIODOCONSOLIDACFINANType;
    }

    public String getCODSOCIEDADACCIONISTA() {
        return this.codsociedadaccionista;
    }

    public void setCODSOCIEDADACCIONISTA(String str) {
        this.codsociedadaccionista = str;
    }

    public String getCODSOCIEDADPARTICIPADA() {
        return this.codsociedadparticipada;
    }

    public void setCODSOCIEDADPARTICIPADA(String str) {
        this.codsociedadparticipada = str;
    }

    public String getCODTIPOCARTERA() {
        return this.codtipocartera;
    }

    public void setCODTIPOCARTERA(String str) {
        this.codtipocartera = str;
    }

    public String getCODIGOEMISORPARTENON() {
        return this.codigoemisorpartenon;
    }

    public void setCODIGOEMISORPARTENON(String str) {
        this.codigoemisorpartenon = str;
    }
}
