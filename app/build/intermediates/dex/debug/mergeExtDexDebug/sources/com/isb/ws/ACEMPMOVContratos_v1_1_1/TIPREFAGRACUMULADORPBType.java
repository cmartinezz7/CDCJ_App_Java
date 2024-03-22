package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIP_REF_AGR_ACUMULADOR_PB_Type", propOrder = {"codagrupador", "refagrupador"})
public class TIPREFAGRACUMULADORPBType {
    @XmlElement(name = "COD_AGRUPADOR", required = true)
    protected String codagrupador;
    @XmlElement(name = "REF_AGRUPADOR", required = true)
    protected String refagrupador;

    public String getCODAGRUPADOR() {
        return this.codagrupador;
    }

    public void setCODAGRUPADOR(String str) {
        this.codagrupador = str;
    }

    public String getREFAGRUPADOR() {
        return this.refagrupador;
    }

    public void setREFAGRUPADOR(String str) {
        this.refagrupador = str;
    }
}
