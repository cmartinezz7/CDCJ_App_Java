package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarExpedientes", propOrder = {"arg0"})
public class BuscarExpedientes {
    protected CriterioConsultaExpedientesProfesionales arg0;

    public CriterioConsultaExpedientesProfesionales getArg0() {
        return this.arg0;
    }

    public void setArg0(CriterioConsultaExpedientesProfesionales criterioConsultaExpedientesProfesionales) {
        this.arg0 = criterioConsultaExpedientesProfesionales;
    }
}
