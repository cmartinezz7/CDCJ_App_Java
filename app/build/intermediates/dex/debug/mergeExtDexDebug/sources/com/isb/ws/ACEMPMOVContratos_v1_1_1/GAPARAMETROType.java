package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GA_PARAMETRO_Type", propOrder = {"gacaracteristica", "gacodparametro"})
public class GAPARAMETROType {
    @XmlElement(name = "GA_CARACTERISTICA", required = true)
    protected GACARACTERISTICAType gacaracteristica;
    @XmlElement(name = "GA_COD_PARAMETRO", required = true)
    protected String gacodparametro;

    public GACARACTERISTICAType getGACARACTERISTICA() {
        return this.gacaracteristica;
    }

    public void setGACARACTERISTICA(GACARACTERISTICAType gACARACTERISTICAType) {
        this.gacaracteristica = gACARACTERISTICAType;
    }

    public String getGACODPARAMETRO() {
        return this.gacodparametro;
    }

    public void setGACODPARAMETRO(String str) {
        this.gacodparametro = str;
    }
}
