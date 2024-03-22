package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INSTRUCCION_GESTOR_CBLE_Type", propOrder = {"ordendeservicio", "referenciadefactoria", "operaciongestorcontable", "tipconceptogestorcble"})
public class INSTRUCCIONGESTORCBLEType {
    @XmlElement(name = "OPERACION_GESTOR_CONTABLE", required = true)
    protected String operaciongestorcontable;
    @XmlElement(name = "ORDEN_DE_SERVICIO", required = true)
    protected ORDENDESERVICIOType ordendeservicio;
    @XmlElement(name = "REFERENCIA_DE_FACTORIA", required = true)
    protected String referenciadefactoria;
    @XmlElement(name = "TIP_CONCEPTO_GESTOR_CBLE", required = true)
    protected String tipconceptogestorcble;

    public ORDENDESERVICIOType getORDENDESERVICIO() {
        return this.ordendeservicio;
    }

    public void setORDENDESERVICIO(ORDENDESERVICIOType oRDENDESERVICIOType) {
        this.ordendeservicio = oRDENDESERVICIOType;
    }

    public String getREFERENCIADEFACTORIA() {
        return this.referenciadefactoria;
    }

    public void setREFERENCIADEFACTORIA(String str) {
        this.referenciadefactoria = str;
    }

    public String getOPERACIONGESTORCONTABLE() {
        return this.operaciongestorcontable;
    }

    public void setOPERACIONGESTORCONTABLE(String str) {
        this.operaciongestorcontable = str;
    }

    public String getTIPCONCEPTOGESTORCBLE() {
        return this.tipconceptogestorcble;
    }

    public void setTIPCONCEPTOGESTORCBLE(String str) {
        this.tipconceptogestorcble = str;
    }
}
