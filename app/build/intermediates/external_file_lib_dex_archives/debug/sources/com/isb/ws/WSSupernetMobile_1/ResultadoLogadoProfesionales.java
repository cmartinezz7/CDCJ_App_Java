package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultadoLogadoProfesionales", propOrder = {"tokenSSO"})
public class ResultadoLogadoProfesionales {
    protected String tokenSSO;

    public String getTokenSSO() {
        return this.tokenSSO;
    }

    public void setTokenSSO(String str) {
        this.tokenSSO = str;
    }
}
