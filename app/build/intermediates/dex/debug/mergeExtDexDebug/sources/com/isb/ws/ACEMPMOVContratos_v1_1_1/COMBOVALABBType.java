package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COMBO_VALABB_Type", propOrder = {"empresa", "codcampoformulario", "codvalor"})
public class COMBOVALABBType {
    @XmlElement(name = "COD_CAMPO_FORMULARIO", required = true)
    protected String codcampoformulario;
    @XmlElement(name = "COD_VALOR", required = true)
    protected String codvalor;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODCAMPOFORMULARIO() {
        return this.codcampoformulario;
    }

    public void setCODCAMPOFORMULARIO(String str) {
        this.codcampoformulario = str;
    }

    public String getCODVALOR() {
        return this.codvalor;
    }

    public void setCODVALOR(String str) {
        this.codvalor = str;
    }
}
