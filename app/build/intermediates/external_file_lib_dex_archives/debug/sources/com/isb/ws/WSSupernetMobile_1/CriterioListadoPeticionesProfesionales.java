package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criterioListadoPeticionesProfesionales", propOrder = {"datosAccesoProfesionales", "datosFiltrado", "datosPaginacion"})
public class CriterioListadoPeticionesProfesionales {
    protected DatosAccesoProfesionales datosAccesoProfesionales;
    protected DatosFiltrado datosFiltrado;
    protected DatosPaginacion datosPaginacion;

    public DatosAccesoProfesionales getDatosAccesoProfesionales() {
        return this.datosAccesoProfesionales;
    }

    public void setDatosAccesoProfesionales(DatosAccesoProfesionales datosAccesoProfesionales2) {
        this.datosAccesoProfesionales = datosAccesoProfesionales2;
    }

    public DatosFiltrado getDatosFiltrado() {
        return this.datosFiltrado;
    }

    public void setDatosFiltrado(DatosFiltrado datosFiltrado2) {
        this.datosFiltrado = datosFiltrado2;
    }

    public DatosPaginacion getDatosPaginacion() {
        return this.datosPaginacion;
    }

    public void setDatosPaginacion(DatosPaginacion datosPaginacion2) {
        this.datosPaginacion = datosPaginacion2;
    }
}
