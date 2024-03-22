package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criterioDetalleExpedienteProfesionales", propOrder = {"datosAccesoProfesionales"})
public class CriterioDetalleExpedienteProfesionales {
    protected DatosAccesoProfesionales datosAccesoProfesionales;

    public DatosAccesoProfesionales getDatosAccesoProfesionales() {
        return this.datosAccesoProfesionales;
    }

    public void setDatosAccesoProfesionales(DatosAccesoProfesionales datosAccesoProfesionales2) {
        this.datosAccesoProfesionales = datosAccesoProfesionales2;
    }
}
