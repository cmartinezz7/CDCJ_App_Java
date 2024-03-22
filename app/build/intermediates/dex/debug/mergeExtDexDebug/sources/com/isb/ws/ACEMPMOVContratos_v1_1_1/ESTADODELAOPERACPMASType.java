package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESTADO_DE_LA_OPERAC_PMAS_Type", propOrder = {"clasedeoperacionpmas", "codestd"})
public class ESTADODELAOPERACPMASType {
    @XmlElement(name = "CLASE_DE_OPERACION_PMAS", required = true)
    protected String clasedeoperacionpmas;
    @XmlElement(name = "CODESTD", required = true)
    protected String codestd;

    public String getCLASEDEOPERACIONPMAS() {
        return this.clasedeoperacionpmas;
    }

    public void setCLASEDEOPERACIONPMAS(String str) {
        this.clasedeoperacionpmas = str;
    }

    public String getCODESTD() {
        return this.codestd;
    }

    public void setCODESTD(String str) {
        this.codestd = str;
    }
}
