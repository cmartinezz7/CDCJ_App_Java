package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "faultcode", namespace = "http://www.gruposantander.es/webservices/genericFault", propOrder = {"value", "subcode"})
public class Faultcode {
    @XmlElement(name = "Subcode")
    protected Subcode subcode;
    @XmlElement(name = "Value", required = true)
    protected String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public Subcode getSubcode() {
        return this.subcode;
    }

    public void setSubcode(Subcode subcode2) {
        this.subcode = subcode2;
    }
}
