package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRIT_AGR_SERVIC_CANAL_CSC_Type", propOrder = {"empresa", "canal", "canalelect", "codcritagrupacion"})
public class CRITAGRSERVICCANALCSCType {
    @XmlElement(name = "CANAL", required = true)
    protected String canal;
    @XmlElement(name = "CANAL_ELECT", required = true)
    protected String canalelect;
    @XmlElement(name = "COD_CRIT_AGRUPACION", required = true)
    protected String codcritagrupacion;
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

    public String getCANALELECT() {
        return this.canalelect;
    }

    public void setCANALELECT(String str) {
        this.canalelect = str;
    }

    public String getCODCRITAGRUPACION() {
        return this.codcritagrupacion;
    }

    public void setCODCRITAGRUPACION(String str) {
        this.codcritagrupacion = str;
    }
}
