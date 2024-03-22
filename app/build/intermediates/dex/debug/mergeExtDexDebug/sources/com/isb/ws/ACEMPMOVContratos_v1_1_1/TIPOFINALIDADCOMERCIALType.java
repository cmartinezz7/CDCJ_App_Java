package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_FINALIDAD_COMERCIAL_Type", propOrder = {"clfinalidadcomercialpr", "tipofinalidad"})
public class TIPOFINALIDADCOMERCIALType {
    @XmlElement(name = "CL_FINALIDAD_COMERCIAL_PR", required = true)
    protected String clfinalidadcomercialpr;
    @XmlElement(name = "TIPO_FINALIDAD", required = true)
    protected String tipofinalidad;

    public String getCLFINALIDADCOMERCIALPR() {
        return this.clfinalidadcomercialpr;
    }

    public void setCLFINALIDADCOMERCIALPR(String str) {
        this.clfinalidadcomercialpr = str;
    }

    public String getTIPOFINALIDAD() {
        return this.tipofinalidad;
    }

    public void setTIPOFINALIDAD(String str) {
        this.tipofinalidad = str;
    }
}
