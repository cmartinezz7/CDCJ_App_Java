package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PERIODICIDAD_MANDATO_PE_Type", propOrder = {"empresa", "tipoperiodicidad", "frecuenciaperiodicidad"})
public class PERIODICIDADMANDATOPEType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "FRECUENCIA_PERIODICIDAD")
    protected int frecuenciaperiodicidad;
    @XmlElement(name = "TIPO_PERIODICIDAD", required = true)
    protected String tipoperiodicidad;

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

    public int getFRECUENCIAPERIODICIDAD() {
        return this.frecuenciaperiodicidad;
    }

    public void setFRECUENCIAPERIODICIDAD(int i) {
        this.frecuenciaperiodicidad = i;
    }
}
