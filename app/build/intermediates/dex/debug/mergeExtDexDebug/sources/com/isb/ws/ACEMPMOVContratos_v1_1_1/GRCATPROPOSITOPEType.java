package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GR_CAT_PROPOSITO_PE_Type", propOrder = {"codgrcatproposito", "codcatproposito"})
public class GRCATPROPOSITOPEType {
    @XmlElement(name = "COD_CAT_PROPOSITO", required = true)
    protected String codcatproposito;
    @XmlElement(name = "COD_GR_CAT_PROPOSITO", required = true)
    protected String codgrcatproposito;

    public String getCODGRCATPROPOSITO() {
        return this.codgrcatproposito;
    }

    public void setCODGRCATPROPOSITO(String str) {
        this.codgrcatproposito = str;
    }

    public String getCODCATPROPOSITO() {
        return this.codcatproposito;
    }

    public void setCODCATPROPOSITO(String str) {
        this.codcatproposito = str;
    }
}
