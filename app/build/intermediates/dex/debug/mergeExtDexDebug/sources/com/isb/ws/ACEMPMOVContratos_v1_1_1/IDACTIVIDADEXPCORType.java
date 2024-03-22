package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_ACTIVIDAD_EXPCOR_Type", propOrder = {"empresa", "codigodeactividad"})
public class IDACTIVIDADEXPCORType {
    @XmlElement(name = "CODIGO_DE_ACTIVIDAD", required = true)
    protected String codigodeactividad;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODIGODEACTIVIDAD() {
        return this.codigodeactividad;
    }

    public void setCODIGODEACTIVIDAD(String str) {
        this.codigodeactividad = str;
    }
}
