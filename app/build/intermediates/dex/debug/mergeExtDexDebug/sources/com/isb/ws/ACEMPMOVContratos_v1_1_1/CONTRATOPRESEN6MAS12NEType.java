package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTRATO_PRESEN_6MAS12_NE_Type", propOrder = {"claveclasificacion", "numerocontrato"})
public class CONTRATOPRESEN6MAS12NEType {
    @XmlElement(name = "CLAVE_CLASIFICACION", required = true)
    protected String claveclasificacion;
    @XmlElement(name = "NUMERO_CONTRATO", required = true)
    protected String numerocontrato;

    public String getCLAVECLASIFICACION() {
        return this.claveclasificacion;
    }

    public void setCLAVECLASIFICACION(String str) {
        this.claveclasificacion = str;
    }

    public String getNUMEROCONTRATO() {
        return this.numerocontrato;
    }

    public void setNUMEROCONTRATO(String str) {
        this.numerocontrato = str;
    }
}
