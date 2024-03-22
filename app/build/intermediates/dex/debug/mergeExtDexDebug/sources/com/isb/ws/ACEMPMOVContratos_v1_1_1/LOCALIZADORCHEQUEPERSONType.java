package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LOCALIZADOR_CHEQUE_PERSON_Type", propOrder = {"claveclasificacion", "numerodecheque"})
public class LOCALIZADORCHEQUEPERSONType {
    @XmlElement(name = "CLAVE_CLASIFICACION", required = true)
    protected LOCALIZADORType claveclasificacion;
    @XmlElement(name = "NUMERO_DE_CHEQUE", required = true)
    protected String numerodecheque;

    public LOCALIZADORType getCLAVECLASIFICACION() {
        return this.claveclasificacion;
    }

    public void setCLAVECLASIFICACION(LOCALIZADORType lOCALIZADORType) {
        this.claveclasificacion = lOCALIZADORType;
    }

    public String getNUMERODECHEQUE() {
        return this.numerodecheque;
    }

    public void setNUMERODECHEQUE(String str) {
        this.numerodecheque = str;
    }
}
