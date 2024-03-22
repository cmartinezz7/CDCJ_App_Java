package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PARAMETRO_Type", propOrder = {"nombreparametro", "tipoparametrobpm", "texto255"})
public class PARAMETROType {
    @XmlElement(name = "NOMBRE_PARAMETRO", required = true)
    protected String nombreparametro;
    @XmlElement(name = "TEXTO_255", required = true)
    protected String texto255;
    @XmlElement(name = "TIPO_PARAMETRO_BPM", required = true)
    protected String tipoparametrobpm;

    public String getNOMBREPARAMETRO() {
        return this.nombreparametro;
    }

    public void setNOMBREPARAMETRO(String str) {
        this.nombreparametro = str;
    }

    public String getTIPOPARAMETROBPM() {
        return this.tipoparametrobpm;
    }

    public void setTIPOPARAMETROBPM(String str) {
        this.tipoparametrobpm = str;
    }

    public String getTEXTO255() {
        return this.texto255;
    }

    public void setTEXTO255(String str) {
        this.texto255 = str;
    }
}
