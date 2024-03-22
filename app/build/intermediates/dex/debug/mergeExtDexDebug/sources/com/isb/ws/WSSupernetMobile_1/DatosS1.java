package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosS1", propOrder = {"codigret", "value"})
public class DatosS1 {
    protected String codigret;
    protected String value;

    public String getCodigret() {
        return this.codigret;
    }

    public void setCodigret(String str) {
        this.codigret = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
