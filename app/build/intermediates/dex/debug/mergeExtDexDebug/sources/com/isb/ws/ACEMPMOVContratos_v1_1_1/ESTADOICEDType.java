package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESTADO_ICED_Type", propOrder = {"llamadagld", "codigoestado"})
public class ESTADOICEDType {
    @XmlElement(name = "CODIGO_ESTADO", required = true)
    protected String codigoestado;
    @XmlElement(name = "LLAMADA_GLD", required = true)
    protected LLAMADAGLDType llamadagld;

    public LLAMADAGLDType getLLAMADAGLD() {
        return this.llamadagld;
    }

    public void setLLAMADAGLD(LLAMADAGLDType lLAMADAGLDType) {
        this.llamadagld = lLAMADAGLDType;
    }

    public String getCODIGOESTADO() {
        return this.codigoestado;
    }

    public void setCODIGOESTADO(String str) {
        this.codigoestado = str;
    }
}
