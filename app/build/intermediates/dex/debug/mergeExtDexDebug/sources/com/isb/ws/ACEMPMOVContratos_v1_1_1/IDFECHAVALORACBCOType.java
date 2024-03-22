package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_FECHA_VALOR_ACBCO_Type", propOrder = {"idaicuerdomensajeacbco", "subtipofechaacbco"})
public class IDFECHAVALORACBCOType {
    @XmlElement(name = "ID_AICUERDO_MENSAJE_ACBCO", required = true)
    protected IDACUERDOMENSAJEACBCOType idaicuerdomensajeacbco;
    @XmlElement(name = "SUBTIPO_FECHA_ACBCO", required = true)
    protected SUBTIPOFECHAACBCOType subtipofechaacbco;

    public IDACUERDOMENSAJEACBCOType getIDAICUERDOMENSAJEACBCO() {
        return this.idaicuerdomensajeacbco;
    }

    public void setIDAICUERDOMENSAJEACBCO(IDACUERDOMENSAJEACBCOType iDACUERDOMENSAJEACBCOType) {
        this.idaicuerdomensajeacbco = iDACUERDOMENSAJEACBCOType;
    }

    public SUBTIPOFECHAACBCOType getSUBTIPOFECHAACBCO() {
        return this.subtipofechaacbco;
    }

    public void setSUBTIPOFECHAACBCO(SUBTIPOFECHAACBCOType sUBTIPOFECHAACBCOType) {
        this.subtipofechaacbco = sUBTIPOFECHAACBCOType;
    }
}
