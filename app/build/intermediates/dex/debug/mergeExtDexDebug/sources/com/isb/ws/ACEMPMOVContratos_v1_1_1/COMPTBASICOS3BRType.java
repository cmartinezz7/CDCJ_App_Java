package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COMPT_BASICOS_3_BR_Type", propOrder = {"penacper", "pepaires", "pesecper", "petipocu", "pecodact"})
public class COMPTBASICOS3BRType {
    @XmlElement(name = "PECODACT", required = true)
    protected String pecodact;
    @XmlElement(name = "PENACPER", required = true)
    protected String penacper;
    @XmlElement(name = "PEPAIRES", required = true)
    protected String pepaires;
    @XmlElement(name = "PESECPER", required = true)
    protected String pesecper;
    @XmlElement(name = "PETIPOCU", required = true)
    protected String petipocu;

    public String getPENACPER() {
        return this.penacper;
    }

    public void setPENACPER(String str) {
        this.penacper = str;
    }

    public String getPEPAIRES() {
        return this.pepaires;
    }

    public void setPEPAIRES(String str) {
        this.pepaires = str;
    }

    public String getPESECPER() {
        return this.pesecper;
    }

    public void setPESECPER(String str) {
        this.pesecper = str;
    }

    public String getPETIPOCU() {
        return this.petipocu;
    }

    public void setPETIPOCU(String str) {
        this.petipocu = str;
    }

    public String getPECODACT() {
        return this.pecodact;
    }

    public void setPECODACT(String str) {
        this.pecodact = str;
    }
}
