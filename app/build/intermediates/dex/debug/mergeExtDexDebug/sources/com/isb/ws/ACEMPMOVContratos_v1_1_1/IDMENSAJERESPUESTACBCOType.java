package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_MENSAJE_RESPUEST_ACBCO_Type", propOrder = {"idacuerdomensajeacbco", "codrespuestaacbco", "menswift"})
public class IDMENSAJERESPUESTACBCOType {
    @XmlElement(name = "COD_RESPUESTA_ACBCO", required = true)
    protected String codrespuestaacbco;
    @XmlElement(name = "ID_ACUERDO_MENSAJE_ACBCO", required = true)
    protected IDACUERDOMENSAJEACBCOType idacuerdomensajeacbco;
    @XmlElement(name = "MENSWIFT", required = true)
    protected String menswift;

    public IDACUERDOMENSAJEACBCOType getIDACUERDOMENSAJEACBCO() {
        return this.idacuerdomensajeacbco;
    }

    public void setIDACUERDOMENSAJEACBCO(IDACUERDOMENSAJEACBCOType iDACUERDOMENSAJEACBCOType) {
        this.idacuerdomensajeacbco = iDACUERDOMENSAJEACBCOType;
    }

    public String getCODRESPUESTAACBCO() {
        return this.codrespuestaacbco;
    }

    public void setCODRESPUESTAACBCO(String str) {
        this.codrespuestaacbco = str;
    }

    public String getMENSWIFT() {
        return this.menswift;
    }

    public void setMENSWIFT(String str) {
        this.menswift = str;
    }
}
