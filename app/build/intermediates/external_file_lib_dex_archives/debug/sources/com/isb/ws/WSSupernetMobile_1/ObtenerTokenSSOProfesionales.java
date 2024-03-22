package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerTokenSSOProfesionales", propOrder = {"arg0"})
public class ObtenerTokenSSOProfesionales {
    protected CriterioLogadoProfesionales arg0;

    public CriterioLogadoProfesionales getArg0() {
        return this.arg0;
    }

    public void setArg0(CriterioLogadoProfesionales criterioLogadoProfesionales) {
        this.arg0 = criterioLogadoProfesionales;
    }
}
