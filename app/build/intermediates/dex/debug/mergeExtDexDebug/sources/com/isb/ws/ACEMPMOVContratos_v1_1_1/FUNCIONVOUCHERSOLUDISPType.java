package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FUNCION_VOUCHER_SOLU_DISP_Type", propOrder = {"funcionvoucherdisp", "codsolucionincidendisp"})
public class FUNCIONVOUCHERSOLUDISPType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_SOLUCION_INCIDEN_DISP")
    protected int codsolucionincidendisp;
    @XmlElement(name = "FUNCION_VOUCHER_DISP", required = true)
    protected FUNCIONVOUCHERDISPType funcionvoucherdisp;

    public FUNCIONVOUCHERDISPType getFUNCIONVOUCHERDISP() {
        return this.funcionvoucherdisp;
    }

    public void setFUNCIONVOUCHERDISP(FUNCIONVOUCHERDISPType fUNCIONVOUCHERDISPType) {
        this.funcionvoucherdisp = fUNCIONVOUCHERDISPType;
    }

    public int getCODSOLUCIONINCIDENDISP() {
        return this.codsolucionincidendisp;
    }

    public void setCODSOLUCIONINCIDENDISP(int i) {
        this.codsolucionincidendisp = i;
    }
}
