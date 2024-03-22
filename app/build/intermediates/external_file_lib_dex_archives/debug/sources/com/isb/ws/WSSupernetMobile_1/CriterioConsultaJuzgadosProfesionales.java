package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criterioConsultaJuzgadosProfesionales", propOrder = {"datosJuzgado", "datosPaginacion"})
public class CriterioConsultaJuzgadosProfesionales {
    protected DatosJuzgado datosJuzgado;
    protected DatosPaginacion datosPaginacion;

    public DatosJuzgado getDatosJuzgado() {
        return this.datosJuzgado;
    }

    public void setDatosJuzgado(DatosJuzgado datosJuzgado2) {
        this.datosJuzgado = datosJuzgado2;
    }

    public DatosPaginacion getDatosPaginacion() {
        return this.datosPaginacion;
    }

    public void setDatosPaginacion(DatosPaginacion datosPaginacion2) {
        this.datosPaginacion = datosPaginacion2;
    }
}
