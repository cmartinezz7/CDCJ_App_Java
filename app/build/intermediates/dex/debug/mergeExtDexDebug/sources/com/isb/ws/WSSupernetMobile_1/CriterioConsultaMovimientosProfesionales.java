package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criterioConsultaMovimientosProfesionales", propOrder = {"datosFiltrado", "datosOperacionProfesionales", "datosPaginacion"})
public class CriterioConsultaMovimientosProfesionales {
    protected DatosFiltrado datosFiltrado;
    protected DatosOperacionProfesionales datosOperacionProfesionales;
    protected DatosPaginacion datosPaginacion;

    public DatosFiltrado getDatosFiltrado() {
        return this.datosFiltrado;
    }

    public void setDatosFiltrado(DatosFiltrado datosFiltrado2) {
        this.datosFiltrado = datosFiltrado2;
    }

    public DatosOperacionProfesionales getDatosOperacionProfesionales() {
        return this.datosOperacionProfesionales;
    }

    public void setDatosOperacionProfesionales(DatosOperacionProfesionales datosOperacionProfesionales2) {
        this.datosOperacionProfesionales = datosOperacionProfesionales2;
    }

    public DatosPaginacion getDatosPaginacion() {
        return this.datosPaginacion;
    }

    public void setDatosPaginacion(DatosPaginacion datosPaginacion2) {
        this.datosPaginacion = datosPaginacion2;
    }
}
