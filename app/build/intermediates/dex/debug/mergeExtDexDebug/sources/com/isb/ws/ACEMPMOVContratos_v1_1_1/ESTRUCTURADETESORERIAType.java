package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESTRUCTURA_DE_TESORERIA_Type", propOrder = {"empresa", "numerodereferencia"})
public class ESTRUCTURADETESORERIAType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "NUMERO_DE_REFERENCIA", required = true)
    protected String numerodereferencia;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getNUMERODEREFERENCIA() {
        return this.numerodereferencia;
    }

    public void setNUMERODEREFERENCIA(String str) {
        this.numerodereferencia = str;
    }
}
