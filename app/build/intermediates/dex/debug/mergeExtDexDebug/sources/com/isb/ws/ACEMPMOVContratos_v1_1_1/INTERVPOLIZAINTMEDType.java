package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INTERV_POLIZA_INTMED_Type", propOrder = {"numpolizaintmed", "tipointervencionintmed", "numordenint"})
public class INTERVPOLIZAINTMEDType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_ORDEN_INT")
    protected int numordenint;
    @XmlElement(name = "NUM_POLIZA_INTMED", required = true)
    protected String numpolizaintmed;
    @XmlElement(name = "TIPO_INTERVENCION_INTMED", required = true)
    protected String tipointervencionintmed;

    public String getNUMPOLIZAINTMED() {
        return this.numpolizaintmed;
    }

    public void setNUMPOLIZAINTMED(String str) {
        this.numpolizaintmed = str;
    }

    public String getTIPOINTERVENCIONINTMED() {
        return this.tipointervencionintmed;
    }

    public void setTIPOINTERVENCIONINTMED(String str) {
        this.tipointervencionintmed = str;
    }

    public int getNUMORDENINT() {
        return this.numordenint;
    }

    public void setNUMORDENINT(int i) {
        this.numordenint = i;
    }
}
