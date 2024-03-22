package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosPlaza", propOrder = {"codplaza", "codprova", "desplaza"})
public class DatosPlaza {
    protected String codplaza;
    protected String codprova;
    protected String desplaza;

    public String getCodplaza() {
        return this.codplaza;
    }

    public void setCodplaza(String str) {
        this.codplaza = str;
    }

    public String getCodprova() {
        return this.codprova;
    }

    public void setCodprova(String str) {
        this.codprova = str;
    }

    public String getDesplaza() {
        return this.desplaza;
    }

    public void setDesplaza(String str) {
        this.desplaza = str;
    }
}
