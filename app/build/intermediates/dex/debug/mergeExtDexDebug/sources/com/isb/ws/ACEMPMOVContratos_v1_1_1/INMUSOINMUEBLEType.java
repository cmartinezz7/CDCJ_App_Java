package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INM_USO_INMUEBLE_Type", propOrder = {"inmgrupouso", "coduso"})
public class INMUSOINMUEBLEType {
    @XmlElement(name = "COD_USO", required = true)
    protected String coduso;
    @XmlElement(name = "INM_GRUPO_USO", required = true)
    protected String inmgrupouso;

    public String getINMGRUPOUSO() {
        return this.inmgrupouso;
    }

    public void setINMGRUPOUSO(String str) {
        this.inmgrupouso = str;
    }

    public String getCODUSO() {
        return this.coduso;
    }

    public void setCODUSO(String str) {
        this.coduso = str;
    }
}
