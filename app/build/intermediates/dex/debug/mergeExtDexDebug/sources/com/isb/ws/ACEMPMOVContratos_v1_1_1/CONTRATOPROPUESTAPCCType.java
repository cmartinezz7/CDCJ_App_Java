package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTRATO_PROPUESTA_PCC_Type", propOrder = {"propuestaderiesgo", "cesta"})
public class CONTRATOPROPUESTAPCCType {
    @XmlElement(name = "CESTA", required = true)
    protected CESTAType cesta;
    @XmlElement(name = "PROPUESTA_DE_RIESGO", required = true)
    protected PROPUESTADERIESGOType propuestaderiesgo;

    public PROPUESTADERIESGOType getPROPUESTADERIESGO() {
        return this.propuestaderiesgo;
    }

    public void setPROPUESTADERIESGO(PROPUESTADERIESGOType pROPUESTADERIESGOType) {
        this.propuestaderiesgo = pROPUESTADERIESGOType;
    }

    public CESTAType getCESTA() {
        return this.cesta;
    }

    public void setCESTA(CESTAType cESTAType) {
        this.cesta = cESTAType;
    }
}
