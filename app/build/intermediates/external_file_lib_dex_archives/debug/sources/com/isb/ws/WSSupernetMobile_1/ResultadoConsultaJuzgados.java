package com.isb.ws.WSSupernetMobile_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultadoConsultaJuzgados", propOrder = {"datosJuzgado", "datosPaginacion"})
public class ResultadoConsultaJuzgados {
    @XmlElement(nillable = true)
    protected List<DatosJuzgado> datosJuzgado;
    protected DatosPaginacion datosPaginacion;

    public List<DatosJuzgado> getDatosJuzgado() {
        if (this.datosJuzgado == null) {
            this.datosJuzgado = new ArrayList();
        }
        return this.datosJuzgado;
    }

    public DatosPaginacion getDatosPaginacion() {
        return this.datosPaginacion;
    }

    public void setDatosPaginacion(DatosPaginacion datosPaginacion2) {
        this.datosPaginacion = datosPaginacion2;
    }
}
