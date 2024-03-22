package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COBRO_GK_Type", propOrder = {"contratogenerador", "idcobro"})
public class COBROGKType {
    @XmlElement(name = "CONTRATO_GENERADOR", required = true)
    protected CONTRATOType contratogenerador;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ID_COBRO")
    protected int idcobro;

    public CONTRATOType getCONTRATOGENERADOR() {
        return this.contratogenerador;
    }

    public void setCONTRATOGENERADOR(CONTRATOType cONTRATOType) {
        this.contratogenerador = cONTRATOType;
    }

    public int getIDCOBRO() {
        return this.idcobro;
    }

    public void setIDCOBRO(int i) {
        this.idcobro = i;
    }
}
