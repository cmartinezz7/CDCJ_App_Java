package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_PRESTACION_CTAS_P_Type", propOrder = {"contrato", "codbeneficiosocial"})
public class IDPRESTACIONCTASPType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_BENEFICIO_SOCIAL")
    protected int codbeneficiosocial;
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public int getCODBENEFICIOSOCIAL() {
        return this.codbeneficiosocial;
    }

    public void setCODBENEFICIOSOCIAL(int i) {
        this.codbeneficiosocial = i;
    }
}
