package com.isb.ws.WSSupernetMobile_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultadoConsultaExpedientes", propOrder = {"datosExpediente", "datosPaginacion"})
public class ResultadoConsultaExpedientes {
    @XmlElement(nillable = true)
    protected List<DatosExpediente> datosExpediente;
    protected DatosPaginacion datosPaginacion;

    public List<DatosExpediente> getDatosExpediente() {
        if (this.datosExpediente == null) {
            this.datosExpediente = new ArrayList();
        }
        return this.datosExpediente;
    }

    public DatosPaginacion getDatosPaginacion() {
        return this.datosPaginacion;
    }

    public void setDatosPaginacion(DatosPaginacion datosPaginacion2) {
        this.datosPaginacion = datosPaginacion2;
    }
}
