package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaMovimientos", propOrder = {"arg0"})
public class ConsultaMovimientos {
    protected CriterioConsultaMovimientosProfesionales arg0;

    public CriterioConsultaMovimientosProfesionales getArg0() {
        return this.arg0;
    }

    public void setArg0(CriterioConsultaMovimientosProfesionales criterioConsultaMovimientosProfesionales) {
        this.arg0 = criterioConsultaMovimientosProfesionales;
    }
}
