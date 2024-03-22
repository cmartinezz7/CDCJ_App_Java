package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OFICINA_BANCARIA_Type", propOrder = {"entidad", "oficina"})
public class OFICINABANCARIAType {
    @XmlElement(name = "ENTIDAD", required = true)
    protected String entidad;
    @XmlElement(name = "OFICINA", required = true)
    protected String oficina;

    public String getENTIDAD() {
        return this.entidad;
    }

    public void setENTIDAD(String str) {
        this.entidad = str;
    }

    public String getOFICINA() {
        return this.oficina;
    }

    public void setOFICINA(String str) {
        this.oficina = str;
    }
}
