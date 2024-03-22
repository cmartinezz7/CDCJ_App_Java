package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TALONARIO_AUTOCHEQ_ACHCAR_Type", propOrder = {"serietalonario", "numerotalonario"})
public class TALONARIOAUTOCHEQACHCARType {
    @XmlElement(name = "NUMERO_TALONARIO", required = true)
    protected String numerotalonario;
    @XmlElement(name = "SERIE_TALONARIO", required = true)
    protected String serietalonario;

    public String getSERIETALONARIO() {
        return this.serietalonario;
    }

    public void setSERIETALONARIO(String str) {
        this.serietalonario = str;
    }

    public String getNUMEROTALONARIO() {
        return this.numerotalonario;
    }

    public void setNUMEROTALONARIO(String str) {
        this.numerotalonario = str;
    }
}
