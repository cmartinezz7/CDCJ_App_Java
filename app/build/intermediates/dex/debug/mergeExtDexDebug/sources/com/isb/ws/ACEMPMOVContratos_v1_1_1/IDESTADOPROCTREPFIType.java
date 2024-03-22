package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_ESTADO_PROC_TREPFI_Type", propOrder = {"idtipestadoproctrepfi", "codestadoproc"})
public class IDESTADOPROCTREPFIType {
    @XmlElement(name = "COD_ESTADO_PROC", required = true)
    protected String codestadoproc;
    @XmlElement(name = "ID_TIP_ESTADO_PROC_TREPFI", required = true)
    protected IDTIPESTADOPROCTREPFIType idtipestadoproctrepfi;

    public IDTIPESTADOPROCTREPFIType getIDTIPESTADOPROCTREPFI() {
        return this.idtipestadoproctrepfi;
    }

    public void setIDTIPESTADOPROCTREPFI(IDTIPESTADOPROCTREPFIType iDTIPESTADOPROCTREPFIType) {
        this.idtipestadoproctrepfi = iDTIPESTADOPROCTREPFIType;
    }

    public String getCODESTADOPROC() {
        return this.codestadoproc;
    }

    public void setCODESTADOPROC(String str) {
        this.codestadoproc = str;
    }
}
