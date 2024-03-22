package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_ACUERDO_CUTOFF_ACBCO_Type", propOrder = {"empresa", "bic", "divisa", "mensaje", "sentido"})
public class IDACUERDOCUTOFFACBCOType {
    @XmlElement(name = "BIC", required = true)
    protected CODIGOBICType bic;
    @XmlElement(name = "DIVISA", required = true)
    protected String divisa;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "MENSAJE", required = true)
    protected String mensaje;
    @XmlElement(name = "SENTIDO", required = true)
    protected String sentido;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public CODIGOBICType getBIC() {
        return this.bic;
    }

    public void setBIC(CODIGOBICType cODIGOBICType) {
        this.bic = cODIGOBICType;
    }

    public String getDIVISA() {
        return this.divisa;
    }

    public void setDIVISA(String str) {
        this.divisa = str;
    }

    public String getMENSAJE() {
        return this.mensaje;
    }

    public void setMENSAJE(String str) {
        this.mensaje = str;
    }

    public String getSENTIDO() {
        return this.sentido;
    }

    public void setSENTIDO(String str) {
        this.sentido = str;
    }
}
