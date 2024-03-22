package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_MENSAJE_SW_Type", propOrder = {"tipomensajesw", "tipocategoriasw", "nummensaje"})
public class IDMENSAJESWType {
    @XmlElement(name = "NUM_MENSAJE", required = true)
    protected String nummensaje;
    @XmlElement(name = "TIPO_CATEGORIA_SW", required = true)
    protected String tipocategoriasw;
    @XmlElement(name = "TIPO_MENSAJE_SW", required = true)
    protected String tipomensajesw;

    public String getTIPOMENSAJESW() {
        return this.tipomensajesw;
    }

    public void setTIPOMENSAJESW(String str) {
        this.tipomensajesw = str;
    }

    public String getTIPOCATEGORIASW() {
        return this.tipocategoriasw;
    }

    public void setTIPOCATEGORIASW(String str) {
        this.tipocategoriasw = str;
    }

    public String getNUMMENSAJE() {
        return this.nummensaje;
    }

    public void setNUMMENSAJE(String str) {
        this.nummensaje = str;
    }
}
