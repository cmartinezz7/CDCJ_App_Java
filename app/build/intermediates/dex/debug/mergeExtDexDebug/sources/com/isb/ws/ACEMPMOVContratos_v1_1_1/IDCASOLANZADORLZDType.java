package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_CASO_LANZADOR_LZD_Type", propOrder = {"empresa", "codigocasolanpro"})
public class IDCASOLANZADORLZDType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_CASO_LANPRO")
    protected long codigocasolanpro;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public long getCODIGOCASOLANPRO() {
        return this.codigocasolanpro;
    }

    public void setCODIGOCASOLANPRO(long j) {
        this.codigocasolanpro = j;
    }
}
