package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_FRAUDE_FRANQ_TJT_Type", propOrder = {"empresa", "tipofranquiciadisputa", "codfraude"})
public class TIPOFRAUDEFRANQTJTType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_FRAUDE")
    protected int codfraude;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "TIPO_FRANQUICIA_DISPUTA")
    protected int tipofranquiciadisputa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getTIPOFRANQUICIADISPUTA() {
        return this.tipofranquiciadisputa;
    }

    public void setTIPOFRANQUICIADISPUTA(int i) {
        this.tipofranquiciadisputa = i;
    }

    public int getCODFRAUDE() {
        return this.codfraude;
    }

    public void setCODFRAUDE(int i) {
        this.codfraude = i;
    }
}
