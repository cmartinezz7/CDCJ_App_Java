package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_FACTURA_TJT_Type", propOrder = {"empresa", "indicador", "tipofactura"})
public class TIPOFACTURATJTType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "INDICADOR")
    protected int indicador;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "TIPO_FACTURA")
    protected int tipofactura;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getINDICADOR() {
        return this.indicador;
    }

    public void setINDICADOR(int i) {
        this.indicador = i;
    }

    public int getTIPOFACTURA() {
        return this.tipofactura;
    }

    public void setTIPOFACTURA(int i) {
        this.tipofactura = i;
    }
}
