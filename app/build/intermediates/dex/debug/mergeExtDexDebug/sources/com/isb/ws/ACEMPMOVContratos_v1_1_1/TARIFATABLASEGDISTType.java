package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TARIFA_TABLA_SEG_DIST_Type", propOrder = {"valorcampoparamseg", "codigotabla"})
public class TARIFATABLASEGDISTType {
    @XmlElement(name = "CODIGO_TABLA", required = true)
    protected String codigotabla;
    @XmlElement(name = "VALOR_CAMPO_PARAM_SEG", required = true)
    protected VALORCAMPOPARAMSEGType valorcampoparamseg;

    public VALORCAMPOPARAMSEGType getVALORCAMPOPARAMSEG() {
        return this.valorcampoparamseg;
    }

    public void setVALORCAMPOPARAMSEG(VALORCAMPOPARAMSEGType vALORCAMPOPARAMSEGType) {
        this.valorcampoparamseg = vALORCAMPOPARAMSEGType;
    }

    public String getCODIGOTABLA() {
        return this.codigotabla;
    }

    public void setCODIGOTABLA(String str) {
        this.codigotabla = str;
    }
}
