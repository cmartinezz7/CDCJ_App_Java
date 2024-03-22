package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalleJuzgado", propOrder = {"arg0"})
public class DetalleJuzgado {
    protected CriterioDetalleJuzgadoProfesionales arg0;

    public CriterioDetalleJuzgadoProfesionales getArg0() {
        return this.arg0;
    }

    public void setArg0(CriterioDetalleJuzgadoProfesionales criterioDetalleJuzgadoProfesionales) {
        this.arg0 = criterioDetalleJuzgadoProfesionales;
    }
}
