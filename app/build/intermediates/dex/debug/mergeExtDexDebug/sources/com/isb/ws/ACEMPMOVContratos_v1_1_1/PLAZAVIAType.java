package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PLAZA_VIA_Type", propOrder = {"plaza", "codigovia", "numeroversionvia"})
public class PLAZAVIAType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_VIA")
    protected int codigovia;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUMERO_VERSION_VIA")
    protected int numeroversionvia;
    @XmlElement(name = "PLAZA", required = true)
    protected PLAZAType plaza;

    public PLAZAType getPLAZA() {
        return this.plaza;
    }

    public void setPLAZA(PLAZAType pLAZAType) {
        this.plaza = pLAZAType;
    }

    public int getCODIGOVIA() {
        return this.codigovia;
    }

    public void setCODIGOVIA(int i) {
        this.codigovia = i;
    }

    public int getNUMEROVERSIONVIA() {
        return this.numeroversionvia;
    }

    public void setNUMEROVERSIONVIA(int i) {
        this.numeroversionvia = i;
    }
}
