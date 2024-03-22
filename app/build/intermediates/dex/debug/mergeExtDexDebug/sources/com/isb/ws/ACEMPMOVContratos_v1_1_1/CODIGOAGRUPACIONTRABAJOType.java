package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CODIGO_AGRUPACION_TRABAJO_Type", propOrder = {"indicadortipotrabajo", "codagrupacionocupacion"})
public class CODIGOAGRUPACIONTRABAJOType {
    @XmlElement(name = "COD_AGRUPACION_OCUPACION", required = true)
    protected String codagrupacionocupacion;
    @XmlElement(name = "INDICADOR_TIPO_TRABAJO", required = true)
    protected String indicadortipotrabajo;

    public String getINDICADORTIPOTRABAJO() {
        return this.indicadortipotrabajo;
    }

    public void setINDICADORTIPOTRABAJO(String str) {
        this.indicadortipotrabajo = str;
    }

    public String getCODAGRUPACIONOCUPACION() {
        return this.codagrupacionocupacion;
    }

    public void setCODAGRUPACIONOCUPACION(String str) {
        this.codagrupacionocupacion = str;
    }
}
