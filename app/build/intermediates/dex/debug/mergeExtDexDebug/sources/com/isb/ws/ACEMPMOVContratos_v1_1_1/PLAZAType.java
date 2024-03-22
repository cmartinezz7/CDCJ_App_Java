package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PLAZA_Type", propOrder = {"provincia", "plaza", "discriminanteplaza"})
public class PLAZAType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "DISCRIMINANTE_PLAZA")
    protected int discriminanteplaza;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "PLAZA")
    protected int plaza;
    @XmlElement(name = "PROVINCIA", required = true)
    protected String provincia;

    public String getPROVINCIA() {
        return this.provincia;
    }

    public void setPROVINCIA(String str) {
        this.provincia = str;
    }

    public int getPLAZA() {
        return this.plaza;
    }

    public void setPLAZA(int i) {
        this.plaza = i;
    }

    public int getDISCRIMINANTEPLAZA() {
        return this.discriminanteplaza;
    }

    public void setDISCRIMINANTEPLAZA(int i) {
        this.discriminanteplaza = i;
    }
}
