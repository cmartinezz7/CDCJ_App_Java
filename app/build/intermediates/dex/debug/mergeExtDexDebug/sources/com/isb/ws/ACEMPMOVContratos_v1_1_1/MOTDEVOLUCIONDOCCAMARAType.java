package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOT_DEVOLUCION_DOC_CAMARA_Type", propOrder = {"codidentsubsistema", "codmotdevolucion"})
public class MOTDEVOLUCIONDOCCAMARAType {
    @XmlElement(name = "COD_IDENT_SUBSISTEMA", required = true)
    protected String codidentsubsistema;
    @XmlElement(name = "COD_MOT_DEVOLUCION", required = true)
    protected String codmotdevolucion;

    public String getCODIDENTSUBSISTEMA() {
        return this.codidentsubsistema;
    }

    public void setCODIDENTSUBSISTEMA(String str) {
        this.codidentsubsistema = str;
    }

    public String getCODMOTDEVOLUCION() {
        return this.codmotdevolucion;
    }

    public void setCODMOTDEVOLUCION(String str) {
        this.codmotdevolucion = str;
    }
}
