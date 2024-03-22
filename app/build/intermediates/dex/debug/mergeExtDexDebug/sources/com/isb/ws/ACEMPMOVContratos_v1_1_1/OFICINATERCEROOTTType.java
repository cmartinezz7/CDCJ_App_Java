package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OFICINA_TERCERO_OTT_Type", propOrder = {"tercero", "codoficina"})
public class OFICINATERCEROOTTType {
    @XmlElement(name = "COD_OFICINA", required = true)
    protected String codoficina;
    @XmlElement(name = "TERCERO", required = true)
    protected TERCEROOTTType tercero;

    public TERCEROOTTType getTERCERO() {
        return this.tercero;
    }

    public void setTERCERO(TERCEROOTTType tERCEROOTTType) {
        this.tercero = tERCEROOTTType;
    }

    public String getCODOFICINA() {
        return this.codoficina;
    }

    public void setCODOFICINA(String str) {
        this.codoficina = str;
    }
}
