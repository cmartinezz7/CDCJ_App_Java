package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REFERENCIA_RETROCESION_Type", propOrder = {"contrato", "codigoreferencia"})
public class REFERENCIARETROCESIONType {
    @XmlElement(name = "CODIGO_REFERENCIA", required = true)
    protected String codigoreferencia;
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public String getCODIGOREFERENCIA() {
        return this.codigoreferencia;
    }

    public void setCODIGOREFERENCIA(String str) {
        this.codigoreferencia = str;
    }
}
