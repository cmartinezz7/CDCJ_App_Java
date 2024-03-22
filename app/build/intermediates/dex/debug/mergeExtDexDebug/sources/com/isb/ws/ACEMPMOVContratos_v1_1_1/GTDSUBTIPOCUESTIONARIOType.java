package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GTD_SUBTIPO_CUESTIONARIO_Type", propOrder = {"gtdtipocuestionario", "codsubtipocuestionario"})
public class GTDSUBTIPOCUESTIONARIOType {
    @XmlElement(name = "COD_SUBTIPO_CUESTIONARIO", required = true)
    protected String codsubtipocuestionario;
    @XmlElement(name = "GTD_TIPO_CUESTIONARIO", required = true)
    protected GTDTIPOCUESTIONARIOType gtdtipocuestionario;

    public GTDTIPOCUESTIONARIOType getGTDTIPOCUESTIONARIO() {
        return this.gtdtipocuestionario;
    }

    public void setGTDTIPOCUESTIONARIO(GTDTIPOCUESTIONARIOType gTDTIPOCUESTIONARIOType) {
        this.gtdtipocuestionario = gTDTIPOCUESTIONARIOType;
    }

    public String getCODSUBTIPOCUESTIONARIO() {
        return this.codsubtipocuestionario;
    }

    public void setCODSUBTIPOCUESTIONARIO(String str) {
        this.codsubtipocuestionario = str;
    }
}
