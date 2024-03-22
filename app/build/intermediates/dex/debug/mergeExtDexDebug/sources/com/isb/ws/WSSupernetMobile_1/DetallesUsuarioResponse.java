package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detallesUsuarioResponse", propOrder = {"_return"})
public class DetallesUsuarioResponse {
    @XmlElement(name = "return")
    protected ResultadoDetalleUsuarioProfesionales _return;

    public ResultadoDetalleUsuarioProfesionales getReturn() {
        return this._return;
    }

    public void setReturn(ResultadoDetalleUsuarioProfesionales resultadoDetalleUsuarioProfesionales) {
        this._return = resultadoDetalleUsuarioProfesionales;
    }
}
