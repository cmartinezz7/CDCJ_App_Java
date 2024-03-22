package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CODIGO_RAZON_TJT_Type", propOrder = {"tipofranquiciadisputa", "codrazon"})
public class CODIGORAZONTJTType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_RAZON")
    protected int codrazon;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "TIPO_FRANQUICIA_DISPUTA")
    protected int tipofranquiciadisputa;

    public int getTIPOFRANQUICIADISPUTA() {
        return this.tipofranquiciadisputa;
    }

    public void setTIPOFRANQUICIADISPUTA(int i) {
        this.tipofranquiciadisputa = i;
    }

    public int getCODRAZON() {
        return this.codrazon;
    }

    public void setCODRAZON(int i) {
        this.codrazon = i;
    }
}
