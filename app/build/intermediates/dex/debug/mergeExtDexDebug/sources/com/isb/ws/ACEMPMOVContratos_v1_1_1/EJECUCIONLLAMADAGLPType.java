package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EJECUCION_LLAMADA_GLP_Type", propOrder = {"codigodeconversacion", "llamadaglp"})
public class EJECUCIONLLAMADAGLPType {
    @XmlElement(name = "CODIGO_DE_CONVERSACION", required = true)
    protected String codigodeconversacion;
    @XmlElement(name = "LLAMADA_GLP", required = true)
    protected LLAMADAGLPType llamadaglp;

    public String getCODIGODECONVERSACION() {
        return this.codigodeconversacion;
    }

    public void setCODIGODECONVERSACION(String str) {
        this.codigodeconversacion = str;
    }

    public LLAMADAGLPType getLLAMADAGLP() {
        return this.llamadaglp;
    }

    public void setLLAMADAGLP(LLAMADAGLPType lLAMADAGLPType) {
        this.llamadaglp = lLAMADAGLPType;
    }
}
