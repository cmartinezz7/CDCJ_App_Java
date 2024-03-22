package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PROPUESTA_PIPECO_Type", propOrder = {"empresa", "idpropuesta", "versionpropuesta"})
public class PROPUESTAPIPECOType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ID_PROPUESTA")
    protected int idpropuesta;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "VERSION_PROPUESTA")
    protected int versionpropuesta;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getIDPROPUESTA() {
        return this.idpropuesta;
    }

    public void setIDPROPUESTA(int i) {
        this.idpropuesta = i;
    }

    public int getVERSIONPROPUESTA() {
        return this.versionpropuesta;
    }

    public void setVERSIONPROPUESTA(int i) {
        this.versionpropuesta = i;
    }
}
