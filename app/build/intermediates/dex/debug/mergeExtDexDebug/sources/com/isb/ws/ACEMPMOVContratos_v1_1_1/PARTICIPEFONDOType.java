package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PARTICIPE_FONDO_Type", propOrder = {"codigodefondo", "numeroparticipe"})
public class PARTICIPEFONDOType {
    @XmlElement(name = "CODIGO_DE_FONDO", required = true)
    protected String codigodefondo;
    @XmlElement(name = "NUMERO_PARTICIPE", required = true)
    protected String numeroparticipe;

    public String getCODIGODEFONDO() {
        return this.codigodefondo;
    }

    public void setCODIGODEFONDO(String str) {
        this.codigodefondo = str;
    }

    public String getNUMEROPARTICIPE() {
        return this.numeroparticipe;
    }

    public void setNUMEROPARTICIPE(String str) {
        this.numeroparticipe = str;
    }
}
