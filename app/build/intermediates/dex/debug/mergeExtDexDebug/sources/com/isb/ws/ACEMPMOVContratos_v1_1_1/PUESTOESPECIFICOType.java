package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PUESTO_ESPECIFICO_Type", propOrder = {"puestotrabajo", "codpuestoesp"})
public class PUESTOESPECIFICOType {
    @XmlElement(name = "COD_PUESTO_ESP", required = true)
    protected String codpuestoesp;
    @XmlElement(name = "PUESTO_TRABAJO", required = true)
    protected PUESTOTRABAJOType puestotrabajo;

    public PUESTOTRABAJOType getPUESTOTRABAJO() {
        return this.puestotrabajo;
    }

    public void setPUESTOTRABAJO(PUESTOTRABAJOType pUESTOTRABAJOType) {
        this.puestotrabajo = pUESTOTRABAJOType;
    }

    public String getCODPUESTOESP() {
        return this.codpuestoesp;
    }

    public void setCODPUESTOESP(String str) {
        this.codpuestoesp = str;
    }
}
