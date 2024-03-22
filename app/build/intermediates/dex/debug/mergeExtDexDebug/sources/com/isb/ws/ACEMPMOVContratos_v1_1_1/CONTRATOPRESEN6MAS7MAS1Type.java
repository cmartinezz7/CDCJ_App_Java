package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTRATO_PRESEN_6MAS7MAS1_Type", propOrder = {"claveclasificacion", "numerocontrato", "digitocontrol"})
public class CONTRATOPRESEN6MAS7MAS1Type {
    @XmlElement(name = "CLAVE_CLASIFICACION", required = true)
    protected String claveclasificacion;
    @XmlElement(name = "DIGITO_CONTROL", required = true)
    protected String digitocontrol;
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

    public String getDIGITOCONTROL() {
        return this.digitocontrol;
    }

    public void setDIGITOCONTROL(String str) {
        this.digitocontrol = str;
    }
}
