package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RFRV_FLUJO_OPERACION_Type", propOrder = {"contrato", "codigodeflujo"})
public class RFRVFLUJOOPERACIONType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_DE_FLUJO")
    protected int codigodeflujo;
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public int getCODIGODEFLUJO() {
        return this.codigodeflujo;
    }

    public void setCODIGODEFLUJO(int i) {
        this.codigodeflujo = i;
    }
}
