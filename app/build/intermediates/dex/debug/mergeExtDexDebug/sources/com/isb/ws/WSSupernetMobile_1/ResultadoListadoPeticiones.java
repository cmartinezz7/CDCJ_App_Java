package com.isb.ws.WSSupernetMobile_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultadoListadoPeticiones", propOrder = {"datosAcceso", "datosPaginacion"})
public class ResultadoListadoPeticiones {
    @XmlElement(nillable = true)
    protected List<DatosAcceso> datosAcceso;
    protected DatosPaginacion datosPaginacion;

    public List<DatosAcceso> getDatosAcceso() {
        if (this.datosAcceso == null) {
            this.datosAcceso = new ArrayList();
        }
        return this.datosAcceso;
    }

    public DatosPaginacion getDatosPaginacion() {
        return this.datosPaginacion;
    }

    public void setDatosPaginacion(DatosPaginacion datosPaginacion2) {
        this.datosPaginacion = datosPaginacion2;
    }
}
