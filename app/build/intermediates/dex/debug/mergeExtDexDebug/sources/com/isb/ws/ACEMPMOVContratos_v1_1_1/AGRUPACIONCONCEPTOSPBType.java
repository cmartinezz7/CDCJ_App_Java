package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AGRUPACION_CONCEPTOS_PB_Type", propOrder = {"bloqueconceptospb", "codagrupacionconceptos"})
public class AGRUPACIONCONCEPTOSPBType {
    @XmlElement(name = "BLOQUE_CONCEPTOS_PB", required = true)
    protected BLOQUECONCEPTOSPBType bloqueconceptospb;
    @XmlElement(name = "COD_AGRUPACION_CONCEPTOS", required = true)
    protected String codagrupacionconceptos;

    public BLOQUECONCEPTOSPBType getBLOQUECONCEPTOSPB() {
        return this.bloqueconceptospb;
    }

    public void setBLOQUECONCEPTOSPB(BLOQUECONCEPTOSPBType bLOQUECONCEPTOSPBType) {
        this.bloqueconceptospb = bLOQUECONCEPTOSPBType;
    }

    public String getCODAGRUPACIONCONCEPTOS() {
        return this.codagrupacionconceptos;
    }

    public void setCODAGRUPACIONCONCEPTOS(String str) {
        this.codagrupacionconceptos = str;
    }
}
