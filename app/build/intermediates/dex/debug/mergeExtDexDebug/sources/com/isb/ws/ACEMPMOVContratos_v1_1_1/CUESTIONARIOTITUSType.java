package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CUESTIONARIO_TITUS_Type", propOrder = {"tipocuestionariostitus", "preguntatitus"})
public class CUESTIONARIOTITUSType {
    @XmlElement(name = "PREGUNTA_TITUS", required = true)
    protected String preguntatitus;
    @XmlElement(name = "TIPO_CUESTIONARIOS_TITUS", required = true)
    protected String tipocuestionariostitus;

    public String getTIPOCUESTIONARIOSTITUS() {
        return this.tipocuestionariostitus;
    }

    public void setTIPOCUESTIONARIOSTITUS(String str) {
        this.tipocuestionariostitus = str;
    }

    public String getPREGUNTATITUS() {
        return this.preguntatitus;
    }

    public void setPREGUNTATITUS(String str) {
        this.preguntatitus = str;
    }
}
