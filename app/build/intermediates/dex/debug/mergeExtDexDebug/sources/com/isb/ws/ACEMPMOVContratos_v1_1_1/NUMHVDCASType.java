package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NUM_HVD_CAS_Type", propOrder = {"numhvdcas", "idpropuestacas"})
public class NUMHVDCASType {
    @XmlElement(name = "ID_PROPUESTA_CAS", required = true)
    protected String idpropuestacas;
    @XmlElement(name = "NUM_HVD_CAS", required = true)
    protected String numhvdcas;

    public String getNUMHVDCAS() {
        return this.numhvdcas;
    }

    public void setNUMHVDCAS(String str) {
        this.numhvdcas = str;
    }

    public String getIDPROPUESTACAS() {
        return this.idpropuestacas;
    }

    public void setIDPROPUESTACAS(String str) {
        this.idpropuestacas = str;
    }
}
