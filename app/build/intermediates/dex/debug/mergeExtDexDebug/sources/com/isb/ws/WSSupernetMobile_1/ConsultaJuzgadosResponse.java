package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaJuzgadosResponse", propOrder = {"_return"})
public class ConsultaJuzgadosResponse {
    @XmlElement(name = "return")
    protected ResultadoConsultaJuzgados _return;

    public ResultadoConsultaJuzgados getReturn() {
        return this._return;
    }

    public void setReturn(ResultadoConsultaJuzgados resultadoConsultaJuzgados) {
        this._return = resultadoConsultaJuzgados;
    }
}
