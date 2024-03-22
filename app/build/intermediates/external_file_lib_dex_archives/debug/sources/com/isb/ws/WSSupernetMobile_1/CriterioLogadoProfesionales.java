package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criterioLogadoProfesionales", propOrder = {"acceso", "token"})
public class CriterioLogadoProfesionales {
    protected String acceso;
    protected String token;

    public String getAcceso() {
        return this.acceso;
    }

    public void setAcceso(String str) {
        this.acceso = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
