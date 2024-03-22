package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESTADO_FUNCIONAMIENTO_PBC_Type", propOrder = {"empresa", "canal", "codestadopc"})
public class ESTADOFUNCIONAMIENTOPBCType {
    @XmlElement(name = "CANAL", required = true)
    protected String canal;
    @XmlElement(name = "COD_ESTADO_PC", required = true)
    protected String codestadopc;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCANAL() {
        return this.canal;
    }

    public void setCANAL(String str) {
        this.canal = str;
    }

    public String getCODESTADOPC() {
        return this.codestadopc;
    }

    public void setCODESTADOPC(String str) {
        this.codestadopc = str;
    }
}
