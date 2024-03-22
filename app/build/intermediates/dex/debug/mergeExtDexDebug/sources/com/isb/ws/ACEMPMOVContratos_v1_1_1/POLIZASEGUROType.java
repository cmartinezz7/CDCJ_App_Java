package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POLIZA_SEGURO_Type", propOrder = {"compania", "ramo", "modalidad", "numeropoliza", "numerocertificado"})
public class POLIZASEGUROType {
    @XmlElement(name = "COMPANIA", required = true)
    protected String compania;
    @XmlElement(name = "MODALIDAD", required = true)
    protected String modalidad;
    @XmlElement(name = "NUMERO_CERTIFICADO", required = true)
    protected String numerocertificado;
    @XmlElement(name = "NUMERO_POLIZA", required = true)
    protected String numeropoliza;
    @XmlElement(name = "RAMO", required = true)
    protected String ramo;

    public String getCOMPANIA() {
        return this.compania;
    }

    public void setCOMPANIA(String str) {
        this.compania = str;
    }

    public String getRAMO() {
        return this.ramo;
    }

    public void setRAMO(String str) {
        this.ramo = str;
    }

    public String getMODALIDAD() {
        return this.modalidad;
    }

    public void setMODALIDAD(String str) {
        this.modalidad = str;
    }

    public String getNUMEROPOLIZA() {
        return this.numeropoliza;
    }

    public void setNUMEROPOLIZA(String str) {
        this.numeropoliza = str;
    }

    public String getNUMEROCERTIFICADO() {
        return this.numerocertificado;
    }

    public void setNUMEROCERTIFICADO(String str) {
        this.numerocertificado = str;
    }
}
