package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACTIVIDAD_ICED_Type", propOrder = {"llamadagld", "codigoactividad"})
public class ACTIVIDADICEDType {
    @XmlElement(name = "CODIGO_ACTIVIDAD", required = true)
    protected String codigoactividad;
    @XmlElement(name = "LLAMADA_GLD", required = true)
    protected LLAMADAGLDType llamadagld;

    public LLAMADAGLDType getLLAMADAGLD() {
        return this.llamadagld;
    }

    public void setLLAMADAGLD(LLAMADAGLDType lLAMADAGLDType) {
        this.llamadagld = lLAMADAGLDType;
    }

    public String getCODIGOACTIVIDAD() {
        return this.codigoactividad;
    }

    public void setCODIGOACTIVIDAD(String str) {
        this.codigoactividad = str;
    }
}
