package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_OPERACION_PBC_Type", propOrder = {"empresa", "canal", "tipooperpbc"})
public class TIPOOPERACIONPBCType {
    @XmlElement(name = "CANAL", required = true)
    protected String canal;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_OPER_PBC", required = true)
    protected String tipooperpbc;

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

    public String getTIPOOPERPBC() {
        return this.tipooperpbc;
    }

    public void setTIPOOPERPBC(String str) {
        this.tipooperpbc = str;
    }
}
