package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RANGO_DE_FECHAS_PRUEBA_Type", propOrder = {"fechainicio", "fechafin"})
public class RANGODEFECHASPRUEBAType {
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_FIN", required = true)
    protected XMLGregorianCalendar fechafin;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_INICIO", required = true)
    protected XMLGregorianCalendar fechainicio;

    public XMLGregorianCalendar getFECHAINICIO() {
        return this.fechainicio;
    }

    public void setFECHAINICIO(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechainicio = xMLGregorianCalendar;
    }

    public XMLGregorianCalendar getFECHAFIN() {
        return this.fechafin;
    }

    public void setFECHAFIN(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechafin = xMLGregorianCalendar;
    }
}
