package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NUM_POLIZA_DISTR_INTMED_Type", propOrder = {"iddistribuidorintmed", "numpolizadistribucion"})
public class NUMPOLIZADISTRINTMEDType {
    @XmlElement(name = "ID_DISTRIBUIDOR_INTMED", required = true)
    protected String iddistribuidorintmed;
    @XmlElement(name = "NUM_POLIZA_DISTRIBUCION", required = true)
    protected String numpolizadistribucion;

    public String getIDDISTRIBUIDORINTMED() {
        return this.iddistribuidorintmed;
    }

    public void setIDDISTRIBUIDORINTMED(String str) {
        this.iddistribuidorintmed = str;
    }

    public String getNUMPOLIZADISTRIBUCION() {
        return this.numpolizadistribucion;
    }

    public void setNUMPOLIZADISTRIBUCION(String str) {
        this.numpolizadistribucion = str;
    }
}
