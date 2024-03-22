package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIP_CARACT_AGRUP_ACTI_GP_Type", propOrder = {"tipodeactivo", "tipodecaracteristica"})
public class TIPCARACTAGRUPACTIGPType {
    @XmlElement(name = "TIPO_DE_ACTIVO", required = true)
    protected String tipodeactivo;
    @XmlElement(name = "TIPO_DE_CARACTERISTICA", required = true)
    protected String tipodecaracteristica;

    public String getTIPODEACTIVO() {
        return this.tipodeactivo;
    }

    public void setTIPODEACTIVO(String str) {
        this.tipodeactivo = str;
    }

    public String getTIPODECARACTERISTICA() {
        return this.tipodecaracteristica;
    }

    public void setTIPODECARACTERISTICA(String str) {
        this.tipodecaracteristica = str;
    }
}
