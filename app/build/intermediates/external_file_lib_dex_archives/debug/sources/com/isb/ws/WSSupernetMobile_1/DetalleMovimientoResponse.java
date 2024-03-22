package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalleMovimientoResponse", propOrder = {"_return"})
public class DetalleMovimientoResponse {
    @XmlElement(name = "return")
    protected ResultadoDetalleOperacion _return;

    public ResultadoDetalleOperacion getReturn() {
        return this._return;
    }

    public void setReturn(ResultadoDetalleOperacion resultadoDetalleOperacion) {
        this._return = resultadoDetalleOperacion;
    }
}
