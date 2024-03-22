package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalleJuzgadoResponse", propOrder = {"_return"})
public class DetalleJuzgadoResponse {
    @XmlElement(name = "return")
    protected ResultadoDetalleJuzgado _return;

    public ResultadoDetalleJuzgado getReturn() {
        return this._return;
    }

    public void setReturn(ResultadoDetalleJuzgado resultadoDetalleJuzgado) {
        this._return = resultadoDetalleJuzgado;
    }
}
