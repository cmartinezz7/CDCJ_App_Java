package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MODALIDAD_DE_SEGUROS_Type", propOrder = {"ramodeseguros", "codproducto"})
public class MODALIDADDESEGUROSType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_PRODUCTO")
    protected int codproducto;
    @XmlElement(name = "RAMO_DE_SEGUROS", required = true)
    protected RAMODESEGUROSType ramodeseguros;

    public RAMODESEGUROSType getRAMODESEGUROS() {
        return this.ramodeseguros;
    }

    public void setRAMODESEGUROS(RAMODESEGUROSType rAMODESEGUROSType) {
        this.ramodeseguros = rAMODESEGUROSType;
    }

    public int getCODPRODUCTO() {
        return this.codproducto;
    }

    public void setCODPRODUCTO(int i) {
        this.codproducto = i;
    }
}
