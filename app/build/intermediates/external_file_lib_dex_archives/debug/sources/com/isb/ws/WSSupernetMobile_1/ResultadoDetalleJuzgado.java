package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultadoDetalleJuzgado", propOrder = {"datosJuzgado"})
public class ResultadoDetalleJuzgado {
    protected DatosJuzgado datosJuzgado;

    public DatosJuzgado getDatosJuzgado() {
        return this.datosJuzgado;
    }

    public void setDatosJuzgado(DatosJuzgado datosJuzgado2) {
        this.datosJuzgado = datosJuzgado2;
    }
}
