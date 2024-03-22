package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REL_AGRUPAC_CUENTA_EEFF_Type", propOrder = {"plancontableeeff", "codmodeloeeff", "codagrupacioneeff", "codcuentaeeff"})
public class RELAGRUPACCUENTAEEFFType {
    @XmlElement(name = "COD_AGRUPACION_EEFF", required = true)
    protected String codagrupacioneeff;
    @XmlElement(name = "COD_CUENTA_EEFF", required = true)
    protected String codcuentaeeff;
    @XmlElement(name = "COD_MODELO_EEFF", required = true)
    protected String codmodeloeeff;
    @XmlElement(name = "PLAN_CONTABLE_EEFF", required = true)
    protected PLANCONTABLEEEFFType plancontableeeff;

    public PLANCONTABLEEEFFType getPLANCONTABLEEEFF() {
        return this.plancontableeeff;
    }

    public void setPLANCONTABLEEEFF(PLANCONTABLEEEFFType pLANCONTABLEEEFFType) {
        this.plancontableeeff = pLANCONTABLEEEFFType;
    }

    public String getCODMODELOEEFF() {
        return this.codmodeloeeff;
    }

    public void setCODMODELOEEFF(String str) {
        this.codmodeloeeff = str;
    }

    public String getCODAGRUPACIONEEFF() {
        return this.codagrupacioneeff;
    }

    public void setCODAGRUPACIONEEFF(String str) {
        this.codagrupacioneeff = str;
    }

    public String getCODCUENTAEEFF() {
        return this.codcuentaeeff;
    }

    public void setCODCUENTAEEFF(String str) {
        this.codcuentaeeff = str;
    }
}
