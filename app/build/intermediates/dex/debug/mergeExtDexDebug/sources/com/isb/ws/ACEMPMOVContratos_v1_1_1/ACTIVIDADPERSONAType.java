package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACTIVIDAD_PERSONA_Type", propOrder = {"indicadortrabajo", "codigodeactividad"})
public class ACTIVIDADPERSONAType {
    @XmlElement(name = "CODIGO_DE_ACTIVIDAD", required = true)
    protected String codigodeactividad;
    @XmlElement(name = "INDICADOR_TRABAJO", required = true)
    protected String indicadortrabajo;

    public String getINDICADORTRABAJO() {
        return this.indicadortrabajo;
    }

    public void setINDICADORTRABAJO(String str) {
        this.indicadortrabajo = str;
    }

    public String getCODIGODEACTIVIDAD() {
        return this.codigodeactividad;
    }

    public void setCODIGODEACTIVIDAD(String str) {
        this.codigodeactividad = str;
    }
}
