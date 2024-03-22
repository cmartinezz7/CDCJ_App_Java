package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NUM_PERSONA_ACTUANTE_Type", propOrder = {"tipodeactuante", "numerodeactuante"})
public class NUMPERSONAACTUANTEType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUMERO_DE_ACTUANTE")
    protected long numerodeactuante;
    @XmlElement(name = "TIPO_DE_ACTUANTE", required = true)
    protected TIPODEACTUANTEType tipodeactuante;

    public TIPODEACTUANTEType getTIPODEACTUANTE() {
        return this.tipodeactuante;
    }

    public void setTIPODEACTUANTE(TIPODEACTUANTEType tIPODEACTUANTEType) {
        this.tipodeactuante = tIPODEACTUANTEType;
    }

    public long getNUMERODEACTUANTE() {
        return this.numerodeactuante;
    }

    public void setNUMERODEACTUANTE(long j) {
        this.numerodeactuante = j;
    }
}
