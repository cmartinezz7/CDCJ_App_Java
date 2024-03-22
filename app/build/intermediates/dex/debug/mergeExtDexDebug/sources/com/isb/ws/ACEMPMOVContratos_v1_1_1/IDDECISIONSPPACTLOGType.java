package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_DECISION_SPP_ACTLOG_Type", propOrder = {"workflowactlog", "codspp"})
public class IDDECISIONSPPACTLOGType {
    @XmlElement(name = "COD_SPP", required = true)
    protected String codspp;
    @XmlElement(name = "WORKFLOW_ACTLOG", required = true)
    protected WORKFLOWACTLOGType workflowactlog;

    public WORKFLOWACTLOGType getWORKFLOWACTLOG() {
        return this.workflowactlog;
    }

    public void setWORKFLOWACTLOG(WORKFLOWACTLOGType wORKFLOWACTLOGType) {
        this.workflowactlog = wORKFLOWACTLOGType;
    }

    public String getCODSPP() {
        return this.codspp;
    }

    public void setCODSPP(String str) {
        this.codspp = str;
    }
}
