package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTRATO_PRESEN_6MAS9MAS3_Type", propOrder = {"claveclasificacion", "numerocontrato1", "numerocontrato2"})
public class CONTRATOPRESEN6MAS9MAS3Type {
    @XmlElement(name = "CLAVE_CLASIFICACION", required = true)
    protected String claveclasificacion;
    @XmlElement(name = "NUMERO_CONTRATO_1", required = true)
    protected String numerocontrato1;
    @XmlElement(name = "NUMERO_CONTRATO_2", required = true)
    protected String numerocontrato2;

    public String getCLAVECLASIFICACION() {
        return this.claveclasificacion;
    }

    public void setCLAVECLASIFICACION(String str) {
        this.claveclasificacion = str;
    }

    public String getNUMEROCONTRATO1() {
        return this.numerocontrato1;
    }

    public void setNUMEROCONTRATO1(String str) {
        this.numerocontrato1 = str;
    }

    public String getNUMEROCONTRATO2() {
        return this.numerocontrato2;
    }

    public void setNUMEROCONTRATO2(String str) {
        this.numerocontrato2 = str;
    }
}
