package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOT_CHARGEBACK_FRANQ_DISP_Type", propOrder = {"funcionchargebackdisp", "codrazon"})
public class MOTCHARGEBACKFRANQDISPType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_RAZON")
    protected int codrazon;
    @XmlElement(name = "FUNCION_CHARGEBACK_DISP", required = true)
    protected FUNCIONCHARGEBACKDISPType funcionchargebackdisp;

    public FUNCIONCHARGEBACKDISPType getFUNCIONCHARGEBACKDISP() {
        return this.funcionchargebackdisp;
    }

    public void setFUNCIONCHARGEBACKDISP(FUNCIONCHARGEBACKDISPType fUNCIONCHARGEBACKDISPType) {
        this.funcionchargebackdisp = fUNCIONCHARGEBACKDISPType;
    }

    public int getCODRAZON() {
        return this.codrazon;
    }

    public void setCODRAZON(int i) {
        this.codrazon = i;
    }
}
