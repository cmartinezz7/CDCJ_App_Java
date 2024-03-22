package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOT_VOUCHER_FRANQ_DISP_Type", propOrder = {"funcionvoucherdisp", "codmotivo"})
public class MOTVOUCHERFRANQDISPType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_MOTIVO")
    protected int codmotivo;
    @XmlElement(name = "FUNCION_VOUCHER_DISP", required = true)
    protected FUNCIONVOUCHERDISPType funcionvoucherdisp;

    public FUNCIONVOUCHERDISPType getFUNCIONVOUCHERDISP() {
        return this.funcionvoucherdisp;
    }

    public void setFUNCIONVOUCHERDISP(FUNCIONVOUCHERDISPType fUNCIONVOUCHERDISPType) {
        this.funcionvoucherdisp = fUNCIONVOUCHERDISPType;
    }

    public int getCODMOTIVO() {
        return this.codmotivo;
    }

    public void setCODMOTIVO(int i) {
        this.codmotivo = i;
    }
}
