package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FIGURA_GESTOR_JUDICIAL_Type", propOrder = {"tipodegestorjudicial", "codfiguragestorjudicia"})
public class FIGURAGESTORJUDICIALType {
    @XmlElement(name = "COD_FIGURA_GESTOR_JUDICIA", required = true)
    protected String codfiguragestorjudicia;
    @XmlElement(name = "TIPO_DE_GESTOR_JUDICIAL", required = true)
    protected TIPODEGESTORJUDICIALType tipodegestorjudicial;

    public TIPODEGESTORJUDICIALType getTIPODEGESTORJUDICIAL() {
        return this.tipodegestorjudicial;
    }

    public void setTIPODEGESTORJUDICIAL(TIPODEGESTORJUDICIALType tIPODEGESTORJUDICIALType) {
        this.tipodegestorjudicial = tIPODEGESTORJUDICIALType;
    }

    public String getCODFIGURAGESTORJUDICIA() {
        return this.codfiguragestorjudicia;
    }

    public void setCODFIGURAGESTORJUDICIA(String str) {
        this.codfiguragestorjudicia = str;
    }
}
