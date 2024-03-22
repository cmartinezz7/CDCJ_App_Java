package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EVENTO_AHGECO_Type", propOrder = {"proyectobksahgeco", "codcanal", "ensambladoahgeco", "codevento"})
public class EVENTOAHGECOType {
    @XmlElement(name = "COD_CANAL", required = true)
    protected String codcanal;
    @XmlElement(name = "COD_EVENTO", required = true)
    protected String codevento;
    @XmlElement(name = "ENSAMBLADO_AHGECO", required = true)
    protected ENSAMBLADOAHGECOType ensambladoahgeco;
    @XmlElement(name = "PROYECTO_BKS_AHGECO", required = true)
    protected PROYECTOBKSAHGECOType proyectobksahgeco;

    public PROYECTOBKSAHGECOType getPROYECTOBKSAHGECO() {
        return this.proyectobksahgeco;
    }

    public void setPROYECTOBKSAHGECO(PROYECTOBKSAHGECOType pROYECTOBKSAHGECOType) {
        this.proyectobksahgeco = pROYECTOBKSAHGECOType;
    }

    public String getCODCANAL() {
        return this.codcanal;
    }

    public void setCODCANAL(String str) {
        this.codcanal = str;
    }

    public ENSAMBLADOAHGECOType getENSAMBLADOAHGECO() {
        return this.ensambladoahgeco;
    }

    public void setENSAMBLADOAHGECO(ENSAMBLADOAHGECOType eNSAMBLADOAHGECOType) {
        this.ensambladoahgeco = eNSAMBLADOAHGECOType;
    }

    public String getCODEVENTO() {
        return this.codevento;
    }

    public void setCODEVENTO(String str) {
        this.codevento = str;
    }
}
