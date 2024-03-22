package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DOCUMENTO_DISPUTA_CC_Type", propOrder = {"disputacc", "numdocumentocc"})
public class DOCUMENTODISPUTACCType {
    @XmlElement(name = "DISPUTA_CC", required = true)
    protected DISPUTACCType disputacc;
    @XmlElement(name = "NUM_DOCUMENTO_CC", required = true)
    protected String numdocumentocc;

    public DISPUTACCType getDISPUTACC() {
        return this.disputacc;
    }

    public void setDISPUTACC(DISPUTACCType dISPUTACCType) {
        this.disputacc = dISPUTACCType;
    }

    public String getNUMDOCUMENTOCC() {
        return this.numdocumentocc;
    }

    public void setNUMDOCUMENTOCC(String str) {
        this.numdocumentocc = str;
    }
}
