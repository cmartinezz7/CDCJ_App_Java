package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GTD_ESTADO_TEST_Type", propOrder = {"gtdtipocuestionario", "codestadotest"})
public class GTDESTADOTESTType {
    @XmlElement(name = "COD_ESTADO_TEST", required = true)
    protected String codestadotest;
    @XmlElement(name = "GTD_TIPO_CUESTIONARIO", required = true)
    protected GTDTIPOCUESTIONARIOType gtdtipocuestionario;

    public GTDTIPOCUESTIONARIOType getGTDTIPOCUESTIONARIO() {
        return this.gtdtipocuestionario;
    }

    public void setGTDTIPOCUESTIONARIO(GTDTIPOCUESTIONARIOType gTDTIPOCUESTIONARIOType) {
        this.gtdtipocuestionario = gTDTIPOCUESTIONARIOType;
    }

    public String getCODESTADOTEST() {
        return this.codestadotest;
    }

    public void setCODESTADOTEST(String str) {
        this.codestadotest = str;
    }
}
