package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CAMPO_Type", propOrder = {"nombrecampo", "texto255"})
public class CAMPOType {
    @XmlElement(name = "NOMBRE_CAMPO", required = true)
    protected String nombrecampo;
    @XmlElement(name = "TEXTO_255", required = true)
    protected String texto255;

    public String getNOMBRECAMPO() {
        return this.nombrecampo;
    }

    public void setNOMBRECAMPO(String str) {
        this.nombrecampo = str;
    }

    public String getTEXTO255() {
        return this.texto255;
    }

    public void setTEXTO255(String str) {
        this.texto255 = str;
    }
}
