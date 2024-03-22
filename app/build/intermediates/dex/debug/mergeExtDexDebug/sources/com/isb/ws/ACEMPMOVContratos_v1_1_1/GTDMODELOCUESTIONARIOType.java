package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GTD_MODELO_CUESTIONARIO_Type", propOrder = {"gtdsubtipocuestionario", "codcuestionario"})
public class GTDMODELOCUESTIONARIOType {
    @XmlElement(name = "COD_CUESTIONARIO", required = true)
    protected String codcuestionario;
    @XmlElement(name = "GTD_SUBTIPO_CUESTIONARIO", required = true)
    protected GTDSUBTIPOCUESTIONARIOType gtdsubtipocuestionario;

    public GTDSUBTIPOCUESTIONARIOType getGTDSUBTIPOCUESTIONARIO() {
        return this.gtdsubtipocuestionario;
    }

    public void setGTDSUBTIPOCUESTIONARIO(GTDSUBTIPOCUESTIONARIOType gTDSUBTIPOCUESTIONARIOType) {
        this.gtdsubtipocuestionario = gTDSUBTIPOCUESTIONARIOType;
    }

    public String getCODCUESTIONARIO() {
        return this.codcuestionario;
    }

    public void setCODCUESTIONARIO(String str) {
        this.codcuestionario = str;
    }
}
