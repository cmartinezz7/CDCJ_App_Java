package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AGRUPADOR_TIPOS_GARANTIA_Type", propOrder = {"empresa", "codagrupaciontipogaran", "codagrupadortipogaran"})
public class AGRUPADORTIPOSGARANTIAType {
    @XmlElement(name = "COD_AGRUPACION_TIPO_GARAN", required = true)
    protected String codagrupaciontipogaran;
    @XmlElement(name = "COD_AGRUPADOR_TIPO_GARAN", required = true)
    protected String codagrupadortipogaran;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODAGRUPACIONTIPOGARAN() {
        return this.codagrupaciontipogaran;
    }

    public void setCODAGRUPACIONTIPOGARAN(String str) {
        this.codagrupaciontipogaran = str;
    }

    public String getCODAGRUPADORTIPOGARAN() {
        return this.codagrupadortipogaran;
    }

    public void setCODAGRUPADORTIPOGARAN(String str) {
        this.codagrupadortipogaran = str;
    }
}
