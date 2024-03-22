package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRITERIO_PERIODICIDAD_PE_Type", propOrder = {"empresa", "tipoperiodicidad", "valortipoperiodicidad"})
public class CRITERIOPERIODICIDADPEType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_PERIODICIDAD", required = true)
    protected String tipoperiodicidad;
    @XmlElement(name = "VALOR_TIPO_PERIODICIDAD", required = true)
    protected String valortipoperiodicidad;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPOPERIODICIDAD() {
        return this.tipoperiodicidad;
    }

    public void setTIPOPERIODICIDAD(String str) {
        this.tipoperiodicidad = str;
    }

    public String getVALORTIPOPERIODICIDAD() {
        return this.valortipoperiodicidad;
    }

    public void setVALORTIPOPERIODICIDAD(String str) {
        this.valortipoperiodicidad = str;
    }
}
