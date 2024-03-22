package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RESPUESTA_CUALITATIVA_Type", propOrder = {"codigopregunta", "ambito", "atributo", "codigorespuesta"})
public class RESPUESTACUALITATIVAType {
    @XmlElement(name = "AMBITO", required = true)
    protected String ambito;
    @XmlElement(name = "ATRIBUTO", required = true)
    protected String atributo;
    @XmlElement(name = "CODIGO_PREGUNTA", required = true)
    protected String codigopregunta;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_RESPUESTA")
    protected int codigorespuesta;

    public String getCODIGOPREGUNTA() {
        return this.codigopregunta;
    }

    public void setCODIGOPREGUNTA(String str) {
        this.codigopregunta = str;
    }

    public String getAMBITO() {
        return this.ambito;
    }

    public void setAMBITO(String str) {
        this.ambito = str;
    }

    public String getATRIBUTO() {
        return this.atributo;
    }

    public void setATRIBUTO(String str) {
        this.atributo = str;
    }

    public int getCODIGORESPUESTA() {
        return this.codigorespuesta;
    }

    public void setCODIGORESPUESTA(int i) {
        this.codigorespuesta = i;
    }
}
