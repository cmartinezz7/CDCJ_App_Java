package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NUM_EXCEP_CAS_Type", propOrder = {"numexcepcas", "numhvdcas"})
public class NUMEXCEPCASType {
    @XmlElement(name = "NUM_EXCEP_CAS", required = true)
    protected String numexcepcas;
    @XmlElement(name = "NUM_HVD_CAS", required = true)
    protected NUMHVDCASType numhvdcas;

    public String getNUMEXCEPCAS() {
        return this.numexcepcas;
    }

    public void setNUMEXCEPCAS(String str) {
        this.numexcepcas = str;
    }

    public NUMHVDCASType getNUMHVDCAS() {
        return this.numhvdcas;
    }

    public void setNUMHVDCAS(NUMHVDCASType nUMHVDCASType) {
        this.numhvdcas = nUMHVDCASType;
    }
}
