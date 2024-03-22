package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESTANDAR_CUALITATIVA_Type", propOrder = {"maestraatributo", "codigorespuesta"})
public class ESTANDARCUALITATIVAType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_RESPUESTA")
    protected int codigorespuesta;
    @XmlElement(name = "MAESTRA_ATRIBUTO", required = true)
    protected MAESTRAATRIBUTOType maestraatributo;

    public MAESTRAATRIBUTOType getMAESTRAATRIBUTO() {
        return this.maestraatributo;
    }

    public void setMAESTRAATRIBUTO(MAESTRAATRIBUTOType mAESTRAATRIBUTOType) {
        this.maestraatributo = mAESTRAATRIBUTOType;
    }

    public int getCODIGORESPUESTA() {
        return this.codigorespuesta;
    }

    public void setCODIGORESPUESTA(int i) {
        this.codigorespuesta = i;
    }
}
