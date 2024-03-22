package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REGLA_APODERAMIENTO_Type", propOrder = {"idexpedienteapod", "codreglaapod"})
public class REGLAAPODERAMIENTOType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_REGLA_APOD")
    protected int codreglaapod;
    @XmlElement(name = "ID_EXPEDIENTE_APOD", required = true)
    protected EXPEDIENTEAPODERAMIENTOType idexpedienteapod;

    public EXPEDIENTEAPODERAMIENTOType getIDEXPEDIENTEAPOD() {
        return this.idexpedienteapod;
    }

    public void setIDEXPEDIENTEAPOD(EXPEDIENTEAPODERAMIENTOType eXPEDIENTEAPODERAMIENTOType) {
        this.idexpedienteapod = eXPEDIENTEAPODERAMIENTOType;
    }

    public int getCODREGLAAPOD() {
        return this.codreglaapod;
    }

    public void setCODREGLAAPOD(int i) {
        this.codreglaapod = i;
    }
}
