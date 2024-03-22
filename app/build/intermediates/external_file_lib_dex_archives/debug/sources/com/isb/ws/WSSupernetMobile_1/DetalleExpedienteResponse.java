package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalleExpedienteResponse", propOrder = {"_return"})
public class DetalleExpedienteResponse {
    @XmlElement(name = "return")
    protected ResultadoDetalleExpediente _return;

    public ResultadoDetalleExpediente getReturn() {
        return this._return;
    }

    public void setReturn(ResultadoDetalleExpediente resultadoDetalleExpediente) {
        this._return = resultadoDetalleExpediente;
    }
}
