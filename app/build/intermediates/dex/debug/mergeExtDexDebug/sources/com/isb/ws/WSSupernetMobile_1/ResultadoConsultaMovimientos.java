package com.isb.ws.WSSupernetMobile_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultadoConsultaMovimientos", propOrder = {"datosOperacion", "datosPaginacion", "totalMovimiento"})
public class ResultadoConsultaMovimientos {
    @XmlElement(nillable = true)
    protected List<DatosOperacion> datosOperacion;
    protected DatosPaginacion datosPaginacion;
    @XmlElement(nillable = true)
    protected List<TotalMovimiento> totalMovimiento;

    public List<DatosOperacion> getDatosOperacion() {
        if (this.datosOperacion == null) {
            this.datosOperacion = new ArrayList();
        }
        return this.datosOperacion;
    }

    public DatosPaginacion getDatosPaginacion() {
        return this.datosPaginacion;
    }

    public void setDatosPaginacion(DatosPaginacion datosPaginacion2) {
        this.datosPaginacion = datosPaginacion2;
    }

    public List<TotalMovimiento> getTotalMovimiento() {
        if (this.totalMovimiento == null) {
            this.totalMovimiento = new ArrayList();
        }
        return this.totalMovimiento;
    }
}
