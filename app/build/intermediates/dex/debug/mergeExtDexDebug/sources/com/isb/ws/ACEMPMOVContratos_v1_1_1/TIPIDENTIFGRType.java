package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIP_IDENTIF_GR_Type", propOrder = {"empresa", "tipogestoremisoresiso"})
public class TIPIDENTIFGRType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_GESTOR_EMISORES_ISO", required = true)
    protected String tipogestoremisoresiso;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPOGESTOREMISORESISO() {
        return this.tipogestoremisoresiso;
    }

    public void setTIPOGESTOREMISORESISO(String str) {
        this.tipogestoremisoresiso = str;
    }
}
