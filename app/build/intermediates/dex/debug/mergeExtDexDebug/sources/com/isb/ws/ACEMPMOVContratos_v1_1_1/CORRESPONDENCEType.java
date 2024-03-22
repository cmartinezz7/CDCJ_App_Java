package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CORRESPONDENCE_Type", propOrder = {"dataset", "claveorigen"})
public class CORRESPONDENCEType {
    @XmlElement(name = "CLAVE_ORIGEN", required = true)
    protected String claveorigen;
    @XmlElement(name = "DATA_SET", required = true)
    protected DATASETType dataset;

    public DATASETType getDATASET() {
        return this.dataset;
    }

    public void setDATASET(DATASETType dATASETType) {
        this.dataset = dATASETType;
    }

    public String getCLAVEORIGEN() {
        return this.claveorigen;
    }

    public void setCLAVEORIGEN(String str) {
        this.claveorigen = str;
    }
}
