package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RECEIPT_DATA_Type", propOrder = {"key", "value"})
public class RECEIPTDATAType {
    @XmlElement(name = "KEY", required = true)
    protected String key;
    @XmlElement(name = "VALUE", required = true)
    protected String value;

    public String getKEY() {
        return this.key;
    }

    public void setKEY(String str) {
        this.key = str;
    }

    public String getVALUE() {
        return this.value;
    }

    public void setVALUE(String str) {
        this.value = str;
    }
}
