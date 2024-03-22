package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INSTRUCCION_SERVICIO_PE_Type", propOrder = {"ordendeservicio", "intruccionordenpe", "orden"})
public class INSTRUCCIONSERVICIOPEType {
    @XmlElement(name = "INTRUCCION_ORDEN_PE", required = true)
    protected String intruccionordenpe;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ORDEN")
    protected int orden;
    @XmlElement(name = "ORDEN_DE_SERVICIO", required = true)
    protected ORDENDESERVICIOType ordendeservicio;

    public ORDENDESERVICIOType getORDENDESERVICIO() {
        return this.ordendeservicio;
    }

    public void setORDENDESERVICIO(ORDENDESERVICIOType oRDENDESERVICIOType) {
        this.ordendeservicio = oRDENDESERVICIOType;
    }

    public String getINTRUCCIONORDENPE() {
        return this.intruccionordenpe;
    }

    public void setINTRUCCIONORDENPE(String str) {
        this.intruccionordenpe = str;
    }

    public int getORDEN() {
        return this.orden;
    }

    public void setORDEN(int i) {
        this.orden = i;
    }
}
