package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RIESGO_POL_DIS_INTMED_Type", propOrder = {"numpolizadistrintmed", "orden"})
public class RIESGOPOLDISINTMEDType {
    @XmlElement(name = "NUM_POLIZA_DISTR_INTMED", required = true)
    protected NUMPOLIZADISTRINTMEDType numpolizadistrintmed;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ORDEN")
    protected int orden;

    public NUMPOLIZADISTRINTMEDType getNUMPOLIZADISTRINTMED() {
        return this.numpolizadistrintmed;
    }

    public void setNUMPOLIZADISTRINTMED(NUMPOLIZADISTRINTMEDType nUMPOLIZADISTRINTMEDType) {
        this.numpolizadistrintmed = nUMPOLIZADISTRINTMEDType;
    }

    public int getORDEN() {
        return this.orden;
    }

    public void setORDEN(int i) {
        this.orden = i;
    }
}
