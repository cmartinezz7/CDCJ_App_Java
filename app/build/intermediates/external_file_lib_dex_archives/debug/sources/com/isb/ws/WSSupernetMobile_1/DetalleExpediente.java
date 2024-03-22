package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalleExpediente", propOrder = {"arg0"})
public class DetalleExpediente {
    protected CriterioDetalleExpedienteProfesionales arg0;

    public CriterioDetalleExpedienteProfesionales getArg0() {
        return this.arg0;
    }

    public void setArg0(CriterioDetalleExpedienteProfesionales criterioDetalleExpedienteProfesionales) {
        this.arg0 = criterioDetalleExpedienteProfesionales;
    }
}
