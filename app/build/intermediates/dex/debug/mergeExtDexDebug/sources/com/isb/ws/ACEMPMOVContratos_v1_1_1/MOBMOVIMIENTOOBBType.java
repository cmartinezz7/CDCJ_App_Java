package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOB_MOVIMIENTO_OBB_Type", propOrder = {"mobasientoobb", "indicadordh", "concepto", "caracteristica"})
public class MOBMOVIMIENTOOBBType {
    @XmlElement(name = "CARACTERISTICA", required = true)
    protected MOBCARACTERISTICAType caracteristica;
    @XmlElement(name = "CONCEPTO", required = true)
    protected String concepto;
    @XmlElement(name = "INDICADOR_DH", required = true)
    protected String indicadordh;
    @XmlElement(name = "MOB_ASIENTO_OBB", required = true)
    protected MOBASIENTOOBBType mobasientoobb;

    public MOBASIENTOOBBType getMOBASIENTOOBB() {
        return this.mobasientoobb;
    }

    public void setMOBASIENTOOBB(MOBASIENTOOBBType mOBASIENTOOBBType) {
        this.mobasientoobb = mOBASIENTOOBBType;
    }

    public String getINDICADORDH() {
        return this.indicadordh;
    }

    public void setINDICADORDH(String str) {
        this.indicadordh = str;
    }

    public String getCONCEPTO() {
        return this.concepto;
    }

    public void setCONCEPTO(String str) {
        this.concepto = str;
    }

    public MOBCARACTERISTICAType getCARACTERISTICA() {
        return this.caracteristica;
    }

    public void setCARACTERISTICA(MOBCARACTERISTICAType mOBCARACTERISTICAType) {
        this.caracteristica = mOBCARACTERISTICAType;
    }
}
