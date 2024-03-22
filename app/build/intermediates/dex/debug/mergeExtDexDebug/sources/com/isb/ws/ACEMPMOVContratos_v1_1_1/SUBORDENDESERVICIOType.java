package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBORDEN_DE_SERVICIO_Type", propOrder = {"ordendeservicio", "suborden"})
public class SUBORDENDESERVICIOType {
    @XmlElement(name = "ORDEN_DE_SERVICIO", required = true)
    protected ORDENDESERVICIOType ordendeservicio;
    @XmlElement(name = "SUBORDEN", required = true)
    protected String suborden;

    public ORDENDESERVICIOType getORDENDESERVICIO() {
        return this.ordendeservicio;
    }

    public void setORDENDESERVICIO(ORDENDESERVICIOType oRDENDESERVICIOType) {
        this.ordendeservicio = oRDENDESERVICIOType;
    }

    public String getSUBORDEN() {
        return this.suborden;
    }

    public void setSUBORDEN(String str) {
        this.suborden = str;
    }
}
