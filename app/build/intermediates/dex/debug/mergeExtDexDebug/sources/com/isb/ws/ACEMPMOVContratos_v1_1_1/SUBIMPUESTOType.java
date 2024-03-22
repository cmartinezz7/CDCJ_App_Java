package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBIMPUESTO_Type", propOrder = {"codimpuesto", "codsubimpuesto"})
public class SUBIMPUESTOType {
    @XmlElement(name = "COD_IMPUESTO", required = true)
    protected String codimpuesto;
    @XmlElement(name = "COD_SUBIMPUESTO", required = true)
    protected String codsubimpuesto;

    public String getCODIMPUESTO() {
        return this.codimpuesto;
    }

    public void setCODIMPUESTO(String str) {
        this.codimpuesto = str;
    }

    public String getCODSUBIMPUESTO() {
        return this.codsubimpuesto;
    }

    public void setCODSUBIMPUESTO(String str) {
        this.codsubimpuesto = str;
    }
}
