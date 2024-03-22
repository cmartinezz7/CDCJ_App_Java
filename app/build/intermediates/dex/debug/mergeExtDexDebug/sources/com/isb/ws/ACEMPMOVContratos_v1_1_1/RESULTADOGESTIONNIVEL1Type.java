package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RESULTADO_GESTION_NIVEL1_Type", propOrder = {"empresa", "canal", "codresultadogestion"})
public class RESULTADOGESTIONNIVEL1Type {
    @XmlElement(name = "CANAL", required = true)
    protected String canal;
    @XmlElement(name = "COD_RESULTADO_GESTION", required = true)
    protected String codresultadogestion;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCANAL() {
        return this.canal;
    }

    public void setCANAL(String str) {
        this.canal = str;
    }

    public String getCODRESULTADOGESTION() {
        return this.codresultadogestion;
    }

    public void setCODRESULTADOGESTION(String str) {
        this.codresultadogestion = str;
    }
}
