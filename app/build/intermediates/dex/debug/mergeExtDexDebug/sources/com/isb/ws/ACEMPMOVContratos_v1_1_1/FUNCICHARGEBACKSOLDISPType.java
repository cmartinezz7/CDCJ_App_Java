package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FUNCI_CHARGEBACK_SOL_DISP_Type", propOrder = {"funcionchargebackdisp", "codsolucionincidendisp", "indchargeback"})
public class FUNCICHARGEBACKSOLDISPType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_SOLUCION_INCIDEN_DISP")
    protected int codsolucionincidendisp;
    @XmlElement(name = "FUNCION_CHARGEBACK_DISP", required = true)
    protected FUNCIONCHARGEBACKDISPType funcionchargebackdisp;
    @XmlElement(name = "IND_CHARGEBACK", required = true)
    protected String indchargeback;

    public FUNCIONCHARGEBACKDISPType getFUNCIONCHARGEBACKDISP() {
        return this.funcionchargebackdisp;
    }

    public void setFUNCIONCHARGEBACKDISP(FUNCIONCHARGEBACKDISPType fUNCIONCHARGEBACKDISPType) {
        this.funcionchargebackdisp = fUNCIONCHARGEBACKDISPType;
    }

    public int getCODSOLUCIONINCIDENDISP() {
        return this.codsolucionincidendisp;
    }

    public void setCODSOLUCIONINCIDENDISP(int i) {
        this.codsolucionincidendisp = i;
    }

    public String getINDCHARGEBACK() {
        return this.indchargeback;
    }

    public void setINDCHARGEBACK(String str) {
        this.indchargeback = str;
    }
}
