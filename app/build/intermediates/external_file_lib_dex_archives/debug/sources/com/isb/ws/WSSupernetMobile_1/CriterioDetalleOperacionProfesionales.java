package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criterioDetalleOperacionProfesionales", propOrder = {"datosOperacionProfesionales"})
public class CriterioDetalleOperacionProfesionales {
    protected DatosOperacionProfesionales datosOperacionProfesionales;

    public DatosOperacionProfesionales getDatosOperacionProfesionales() {
        return this.datosOperacionProfesionales;
    }

    public void setDatosOperacionProfesionales(DatosOperacionProfesionales datosOperacionProfesionales2) {
        this.datosOperacionProfesionales = datosOperacionProfesionales2;
    }
}
