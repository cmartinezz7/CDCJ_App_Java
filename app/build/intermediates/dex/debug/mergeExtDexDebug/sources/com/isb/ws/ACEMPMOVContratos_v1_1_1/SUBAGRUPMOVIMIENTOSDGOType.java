package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBAGRUP_MOVIMIENTOS_DGO_Type", propOrder = {"agrupmovimientos", "subagrupmovimientos"})
public class SUBAGRUPMOVIMIENTOSDGOType {
    @XmlElement(name = "AGRUP_MOVIMIENTOS", required = true)
    protected String agrupmovimientos;
    @XmlElement(name = "SUBAGRUP_MOVIMIENTOS", required = true)
    protected String subagrupmovimientos;

    public String getAGRUPMOVIMIENTOS() {
        return this.agrupmovimientos;
    }

    public void setAGRUPMOVIMIENTOS(String str) {
        this.agrupmovimientos = str;
    }

    public String getSUBAGRUPMOVIMIENTOS() {
        return this.subagrupmovimientos;
    }

    public void setSUBAGRUPMOVIMIENTOS(String str) {
        this.subagrupmovimientos = str;
    }
}
