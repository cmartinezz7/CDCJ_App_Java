package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosActuacionPolicial", propOrder = {"codPolicia", "cpolicia", "jpoliact", "numregpo"})
public class DatosActuacionPolicial {
    protected String codPolicia;
    protected String cpolicia;
    protected String jpoliact;
    protected String numregpo;

    public String getCodPolicia() {
        return this.codPolicia;
    }

    public void setCodPolicia(String str) {
        this.codPolicia = str;
    }

    public String getCpolicia() {
        return this.cpolicia;
    }

    public void setCpolicia(String str) {
        this.cpolicia = str;
    }

    public String getJpoliact() {
        return this.jpoliact;
    }

    public void setJpoliact(String str) {
        this.jpoliact = str;
    }

    public String getNumregpo() {
        return this.numregpo;
    }

    public void setNumregpo(String str) {
        this.numregpo = str;
    }
}
