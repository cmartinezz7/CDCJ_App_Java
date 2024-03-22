package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COD_ACTIVIDAD_TJT_Type", propOrder = {"empresa", "codactividad"})
public class CODACTIVIDADTJTType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_ACTIVIDAD")
    protected int codactividad;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODACTIVIDAD() {
        return this.codactividad;
    }

    public void setCODACTIVIDAD(int i) {
        this.codactividad = i;
    }
}
