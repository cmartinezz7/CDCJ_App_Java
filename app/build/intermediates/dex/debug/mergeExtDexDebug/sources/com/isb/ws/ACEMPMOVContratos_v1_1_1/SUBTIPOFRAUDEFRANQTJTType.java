package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBTIPO_FRAUDE_FRANQ_TJT_Type", propOrder = {"tipofraudefranqtjt", "codsubfraude"})
public class SUBTIPOFRAUDEFRANQTJTType {
    @XmlElement(name = "COD_SUBFRAUDE", required = true)
    protected String codsubfraude;
    @XmlElement(name = "TIPO_FRAUDE_FRANQ_TJT", required = true)
    protected TIPOFRAUDEFRANQTJTType tipofraudefranqtjt;

    public TIPOFRAUDEFRANQTJTType getTIPOFRAUDEFRANQTJT() {
        return this.tipofraudefranqtjt;
    }

    public void setTIPOFRAUDEFRANQTJT(TIPOFRAUDEFRANQTJTType tIPOFRAUDEFRANQTJTType) {
        this.tipofraudefranqtjt = tIPOFRAUDEFRANQTJTType;
    }

    public String getCODSUBFRAUDE() {
        return this.codsubfraude;
    }

    public void setCODSUBFRAUDE(String str) {
        this.codsubfraude = str;
    }
}
