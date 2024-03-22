package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultadoDetalleExpediente", propOrder = {"datosExpediente"})
public class ResultadoDetalleExpediente {
    protected DatosExpediente datosExpediente;

    public DatosExpediente getDatosExpediente() {
        return this.datosExpediente;
    }

    public void setDatosExpediente(DatosExpediente datosExpediente2) {
        this.datosExpediente = datosExpediente2;
    }
}
