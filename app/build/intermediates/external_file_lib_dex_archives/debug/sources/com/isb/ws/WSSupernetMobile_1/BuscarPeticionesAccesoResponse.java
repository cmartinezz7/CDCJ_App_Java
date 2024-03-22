package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarPeticionesAccesoResponse", propOrder = {"_return"})
public class BuscarPeticionesAccesoResponse {
    @XmlElement(name = "return")
    protected ResultadoListadoPeticiones _return;

    public ResultadoListadoPeticiones getReturn() {
        return this._return;
    }

    public void setReturn(ResultadoListadoPeticiones resultadoListadoPeticiones) {
        this._return = resultadoListadoPeticiones;
    }
}
