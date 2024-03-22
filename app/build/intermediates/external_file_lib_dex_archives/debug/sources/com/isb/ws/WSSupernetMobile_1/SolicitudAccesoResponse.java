package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudAccesoResponse", propOrder = {"_return"})
public class SolicitudAccesoResponse {
    @XmlElement(name = "return")
    protected ResultadoSolicitudAcceso _return;

    public ResultadoSolicitudAcceso getReturn() {
        return this._return;
    }

    public void setReturn(ResultadoSolicitudAcceso resultadoSolicitudAcceso) {
        this._return = resultadoSolicitudAcceso;
    }
}
