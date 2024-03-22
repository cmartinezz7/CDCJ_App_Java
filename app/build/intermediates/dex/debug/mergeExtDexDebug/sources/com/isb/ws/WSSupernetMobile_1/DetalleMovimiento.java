package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalleMovimiento", propOrder = {"arg0"})
public class DetalleMovimiento {
    protected CriterioDetalleOperacionProfesionales arg0;

    public CriterioDetalleOperacionProfesionales getArg0() {
        return this.arg0;
    }

    public void setArg0(CriterioDetalleOperacionProfesionales criterioDetalleOperacionProfesionales) {
        this.arg0 = criterioDetalleOperacionProfesionales;
    }
}
