package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RESP_PARAM_CUALIT_RO_Type", propOrder = {"respuestaparamro", "codigorespuestaro"})
public class RESPPARAMCUALITROType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_RESPUESTA_RO")
    protected int codigorespuestaro;
    @XmlElement(name = "RESPUESTA_PARAM_RO", required = true)
    protected RESPUESTAPARAMROType respuestaparamro;

    public RESPUESTAPARAMROType getRESPUESTAPARAMRO() {
        return this.respuestaparamro;
    }

    public void setRESPUESTAPARAMRO(RESPUESTAPARAMROType rESPUESTAPARAMROType) {
        this.respuestaparamro = rESPUESTAPARAMROType;
    }

    public int getCODIGORESPUESTARO() {
        return this.codigorespuestaro;
    }

    public void setCODIGORESPUESTARO(int i) {
        this.codigorespuestaro = i;
    }
}
