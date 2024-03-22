package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerTokenSSOProfesionalesResponse", propOrder = {"_return"})
public class ObtenerTokenSSOProfesionalesResponse {
    @XmlElement(name = "return")
    protected ResultadoLogadoProfesionales _return;

    public ResultadoLogadoProfesionales getReturn() {
        return this._return;
    }

    public void setReturn(ResultadoLogadoProfesionales resultadoLogadoProfesionales) {
        this._return = resultadoLogadoProfesionales;
    }
}
