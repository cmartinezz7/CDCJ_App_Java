package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultadoDetalleOperacion", propOrder = {"datosOperacion"})
public class ResultadoDetalleOperacion {
    protected DatosOperacion datosOperacion;

    public DatosOperacion getDatosOperacion() {
        return this.datosOperacion;
    }

    public void setDatosOperacion(DatosOperacion datosOperacion2) {
        this.datosOperacion = datosOperacion2;
    }
}
