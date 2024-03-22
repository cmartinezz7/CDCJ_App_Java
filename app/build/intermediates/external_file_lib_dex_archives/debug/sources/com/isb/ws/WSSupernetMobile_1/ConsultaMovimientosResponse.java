package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaMovimientosResponse", propOrder = {"_return"})
public class ConsultaMovimientosResponse {
    @XmlElement(name = "return")
    protected ResultadoConsultaMovimientos _return;

    public ResultadoConsultaMovimientos getReturn() {
        return this._return;
    }

    public void setReturn(ResultadoConsultaMovimientos resultadoConsultaMovimientos) {
        this._return = resultadoConsultaMovimientos;
    }
}
