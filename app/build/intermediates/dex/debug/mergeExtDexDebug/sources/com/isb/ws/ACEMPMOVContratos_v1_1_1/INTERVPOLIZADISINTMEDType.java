package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INTERV_POLIZA_DIS_INTMED_Type", propOrder = {"numpolizadistrintmed", "tipointervencionintmed", "numordeninter"})
public class INTERVPOLIZADISINTMEDType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_ORDEN_INTER")
    protected int numordeninter;
    @XmlElement(name = "NUM_POLIZA_DISTR_INTMED", required = true)
    protected NUMPOLIZADISTRINTMEDType numpolizadistrintmed;
    @XmlElement(name = "TIPO_INTERVENCION_INTMED", required = true)
    protected String tipointervencionintmed;

    public NUMPOLIZADISTRINTMEDType getNUMPOLIZADISTRINTMED() {
        return this.numpolizadistrintmed;
    }

    public void setNUMPOLIZADISTRINTMED(NUMPOLIZADISTRINTMEDType nUMPOLIZADISTRINTMEDType) {
        this.numpolizadistrintmed = nUMPOLIZADISTRINTMEDType;
    }

    public String getTIPOINTERVENCIONINTMED() {
        return this.tipointervencionintmed;
    }

    public void setTIPOINTERVENCIONINTMED(String str) {
        this.tipointervencionintmed = str;
    }

    public int getNUMORDENINTER() {
        return this.numordeninter;
    }

    public void setNUMORDENINTER(int i) {
        this.numordeninter = i;
    }
}
