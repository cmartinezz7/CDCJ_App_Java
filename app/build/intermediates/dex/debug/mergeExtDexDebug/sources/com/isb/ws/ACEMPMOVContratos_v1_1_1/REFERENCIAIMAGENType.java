package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REFERENCIA_IMAGEN_Type", propOrder = {"refimagen", "fechareferencia"})
public class REFERENCIAIMAGENType {
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_REFERENCIA", required = true)
    protected XMLGregorianCalendar fechareferencia;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "REF_IMAGEN")
    protected long refimagen;

    public long getREFIMAGEN() {
        return this.refimagen;
    }

    public void setREFIMAGEN(long j) {
        this.refimagen = j;
    }

    public XMLGregorianCalendar getFECHAREFERENCIA() {
        return this.fechareferencia;
    }

    public void setFECHAREFERENCIA(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechareferencia = xMLGregorianCalendar;
    }
}
