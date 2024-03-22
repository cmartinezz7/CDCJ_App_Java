package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_OBJT_PRECIO_PARTICULAR_Type", propOrder = {"empresa", "tipoobjeto", "contadorobjeto"})
public class IDOBJTPRECIOPARTICULARType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CONTADOR_OBJETO")
    protected long contadorobjeto;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_OBJETO", required = true)
    protected String tipoobjeto;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPOOBJETO() {
        return this.tipoobjeto;
    }

    public void setTIPOOBJETO(String str) {
        this.tipoobjeto = str;
    }

    public long getCONTADOROBJETO() {
        return this.contadorobjeto;
    }

    public void setCONTADOROBJETO(long j) {
        this.contadorobjeto = j;
    }
}
