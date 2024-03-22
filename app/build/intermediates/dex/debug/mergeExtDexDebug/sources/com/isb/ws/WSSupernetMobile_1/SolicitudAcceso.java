package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudAcceso", propOrder = {"arg0"})
public class SolicitudAcceso {
    protected CriterioSolicitudAccesoProfesionales arg0;

    public CriterioSolicitudAccesoProfesionales getArg0() {
        return this.arg0;
    }

    public void setArg0(CriterioSolicitudAccesoProfesionales criterioSolicitudAccesoProfesionales) {
        this.arg0 = criterioSolicitudAccesoProfesionales;
    }
}
