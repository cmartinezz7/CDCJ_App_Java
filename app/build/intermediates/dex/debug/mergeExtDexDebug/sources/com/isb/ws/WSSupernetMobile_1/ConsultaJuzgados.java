package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaJuzgados", propOrder = {"arg0"})
public class ConsultaJuzgados {
    protected CriterioConsultaJuzgadosProfesionales arg0;

    public CriterioConsultaJuzgadosProfesionales getArg0() {
        return this.arg0;
    }

    public void setArg0(CriterioConsultaJuzgadosProfesionales criterioConsultaJuzgadosProfesionales) {
        this.arg0 = criterioConsultaJuzgadosProfesionales;
    }
}
