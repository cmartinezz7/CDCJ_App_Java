package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRATAMIENTO_CONSO_FIN_Type", propOrder = {"entornoconsolidacfinan", "tipotratamientoconfina", "fechaalta"})
public class TRATAMIENTOCONSOFINType {
    @XmlElement(name = "ENTORNO_CONSOLIDAC_FINAN", required = true)
    protected ENTORNOCONSOLIDACFINANType entornoconsolidacfinan;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_ALTA", required = true)
    protected XMLGregorianCalendar fechaalta;
    @XmlElement(name = "TIPO_TRATAMIENTO_CON_FINA", required = true)
    protected String tipotratamientoconfina;

    public ENTORNOCONSOLIDACFINANType getENTORNOCONSOLIDACFINAN() {
        return this.entornoconsolidacfinan;
    }

    public void setENTORNOCONSOLIDACFINAN(ENTORNOCONSOLIDACFINANType eNTORNOCONSOLIDACFINANType) {
        this.entornoconsolidacfinan = eNTORNOCONSOLIDACFINANType;
    }

    public String getTIPOTRATAMIENTOCONFINA() {
        return this.tipotratamientoconfina;
    }

    public void setTIPOTRATAMIENTOCONFINA(String str) {
        this.tipotratamientoconfina = str;
    }

    public XMLGregorianCalendar getFECHAALTA() {
        return this.fechaalta;
    }

    public void setFECHAALTA(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechaalta = xMLGregorianCalendar;
    }
}
