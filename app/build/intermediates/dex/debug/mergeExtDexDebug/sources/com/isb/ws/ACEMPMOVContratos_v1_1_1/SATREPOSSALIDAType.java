package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SATREPOSSALIDA_Type", propOrder = {"satcmaximo", "satlineaspagina", "satindrepos"})
public class SATREPOSSALIDAType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "SATCMAXIMO")
    protected int satcmaximo;
    @XmlElement(name = "SATINDREPOS", required = true)
    protected String satindrepos;
    @XmlElement(name = "SATLINEASPAGINA", required = true)
    protected String satlineaspagina;

    public int getSATCMAXIMO() {
        return this.satcmaximo;
    }

    public void setSATCMAXIMO(int i) {
        this.satcmaximo = i;
    }

    public String getSATLINEASPAGINA() {
        return this.satlineaspagina;
    }

    public void setSATLINEASPAGINA(String str) {
        this.satlineaspagina = str;
    }

    public String getSATINDREPOS() {
        return this.satindrepos;
    }

    public void setSATINDREPOS(String str) {
        this.satindrepos = str;
    }
}
