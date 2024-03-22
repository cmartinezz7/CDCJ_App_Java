package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RIESGO_POL_FAB_INTMED_Type", propOrder = {"numpolizafabricaintmed", "orden"})
public class RIESGOPOLFABINTMEDType {
    @XmlElement(name = "NUM_POLIZA_FABRICA_INTMED", required = true)
    protected NUMPOLIZAFABRICAINTMEDType numpolizafabricaintmed;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ORDEN")
    protected int orden;

    public NUMPOLIZAFABRICAINTMEDType getNUMPOLIZAFABRICAINTMED() {
        return this.numpolizafabricaintmed;
    }

    public void setNUMPOLIZAFABRICAINTMED(NUMPOLIZAFABRICAINTMEDType nUMPOLIZAFABRICAINTMEDType) {
        this.numpolizafabricaintmed = nUMPOLIZAFABRICAINTMEDType;
    }

    public int getORDEN() {
        return this.orden;
    }

    public void setORDEN(int i) {
        this.orden = i;
    }
}
