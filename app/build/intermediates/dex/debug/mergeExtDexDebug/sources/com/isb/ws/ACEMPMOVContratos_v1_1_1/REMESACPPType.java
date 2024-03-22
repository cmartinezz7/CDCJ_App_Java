package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REMESA_CPP_Type", propOrder = {"ordendeservicio", "numremesa"})
public class REMESACPPType {
    @XmlElement(name = "NUM_REMESA", required = true)
    protected String numremesa;
    @XmlElement(name = "ORDEN_DE_SERVICIO", required = true)
    protected ORDENDESERVICIOType ordendeservicio;

    public ORDENDESERVICIOType getORDENDESERVICIO() {
        return this.ordendeservicio;
    }

    public void setORDENDESERVICIO(ORDENDESERVICIOType oRDENDESERVICIOType) {
        this.ordendeservicio = oRDENDESERVICIOType;
    }

    public String getNUMREMESA() {
        return this.numremesa;
    }

    public void setNUMREMESA(String str) {
        this.numremesa = str;
    }
}
