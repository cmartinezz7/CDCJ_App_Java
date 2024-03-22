package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RIESGO_POL_INTMED_Type", propOrder = {"numpolizaintmed", "numriesgo"})
public class RIESGOPOLINTMEDType {
    @XmlElement(name = "NUM_POLIZA_INTMED", required = true)
    protected String numpolizaintmed;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_RIESGO")
    protected int numriesgo;

    public String getNUMPOLIZAINTMED() {
        return this.numpolizaintmed;
    }

    public void setNUMPOLIZAINTMED(String str) {
        this.numpolizaintmed = str;
    }

    public int getNUMRIESGO() {
        return this.numriesgo;
    }

    public void setNUMRIESGO(int i) {
        this.numriesgo = i;
    }
}
