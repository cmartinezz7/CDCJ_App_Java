package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosFirma", propOrder = {"indicadorFirma", "numeroPersona", "tipoPersona"})
public class DatosFirma {
    protected String indicadorFirma;
    protected Long numeroPersona;
    protected String tipoPersona;

    public String getIndicadorFirma() {
        return this.indicadorFirma;
    }

    public void setIndicadorFirma(String str) {
        this.indicadorFirma = str;
    }

    public Long getNumeroPersona() {
        return this.numeroPersona;
    }

    public void setNumeroPersona(Long l) {
        this.numeroPersona = l;
    }

    public String getTipoPersona() {
        return this.tipoPersona;
    }

    public void setTipoPersona(String str) {
        this.tipoPersona = str;
    }
}
