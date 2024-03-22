package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PLANTILLA_EEFF_Type", propOrder = {"codplaneeff", "codmodeeff", "codplantillaeeff"})
public class PLANTILLAEEFFType {
    @XmlElement(name = "CODMOD_EEFF", required = true)
    protected String codmodeeff;
    @XmlElement(name = "CODPLAN_EEFF", required = true)
    protected PLANCONTABLEEEFFType codplaneeff;
    @XmlElement(name = "CODPLANTILLA_EEFF", required = true)
    protected String codplantillaeeff;

    public PLANCONTABLEEEFFType getCODPLANEEFF() {
        return this.codplaneeff;
    }

    public void setCODPLANEEFF(PLANCONTABLEEEFFType pLANCONTABLEEEFFType) {
        this.codplaneeff = pLANCONTABLEEEFFType;
    }

    public String getCODMODEEFF() {
        return this.codmodeeff;
    }

    public void setCODMODEEFF(String str) {
        this.codmodeeff = str;
    }

    public String getCODPLANTILLAEEFF() {
        return this.codplantillaeeff;
    }

    public void setCODPLANTILLAEEFF(String str) {
        this.codplantillaeeff = str;
    }
}
