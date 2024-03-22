package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FINALIDAD_COMERCIAL_PRODU_Type", propOrder = {"tipofinalidadcomercial", "codfinalidadcomercprod"})
public class FINALIDADCOMERCIALPRODUType {
    @XmlElement(name = "COD_FINALIDAD_COMERC_PROD", required = true)
    protected String codfinalidadcomercprod;
    @XmlElement(name = "TIPO_FINALIDAD_COMERCIAL", required = true)
    protected TIPOFINALIDADCOMERCIALType tipofinalidadcomercial;

    public TIPOFINALIDADCOMERCIALType getTIPOFINALIDADCOMERCIAL() {
        return this.tipofinalidadcomercial;
    }

    public void setTIPOFINALIDADCOMERCIAL(TIPOFINALIDADCOMERCIALType tIPOFINALIDADCOMERCIALType) {
        this.tipofinalidadcomercial = tIPOFINALIDADCOMERCIALType;
    }

    public String getCODFINALIDADCOMERCPROD() {
        return this.codfinalidadcomercprod;
    }

    public void setCODFINALIDADCOMERCPROD(String str) {
        this.codfinalidadcomercprod = str;
    }
}
