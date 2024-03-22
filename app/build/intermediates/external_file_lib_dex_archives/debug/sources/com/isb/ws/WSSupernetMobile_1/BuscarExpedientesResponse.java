package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarExpedientesResponse", propOrder = {"_return"})
public class BuscarExpedientesResponse {
    @XmlElement(name = "return")
    protected ResultadoConsultaExpedientes _return;

    public ResultadoConsultaExpedientes getReturn() {
        return this._return;
    }

    public void setReturn(ResultadoConsultaExpedientes resultadoConsultaExpedientes) {
        this._return = resultadoConsultaExpedientes;
    }
}
