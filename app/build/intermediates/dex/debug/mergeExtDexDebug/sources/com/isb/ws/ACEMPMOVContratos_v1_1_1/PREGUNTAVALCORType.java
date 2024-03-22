package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PREGUNTA_VALCOR_Type", propOrder = {"idcuestionariovalcor", "fechainipregunta"})
public class PREGUNTAVALCORType {
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_INI_PREGUNTA", required = true)
    protected XMLGregorianCalendar fechainipregunta;
    @XmlElement(name = "ID_CUESTIONARIO_VALCOR", required = true)
    protected String idcuestionariovalcor;

    public String getIDCUESTIONARIOVALCOR() {
        return this.idcuestionariovalcor;
    }

    public void setIDCUESTIONARIOVALCOR(String str) {
        this.idcuestionariovalcor = str;
    }

    public XMLGregorianCalendar getFECHAINIPREGUNTA() {
        return this.fechainipregunta;
    }

    public void setFECHAINIPREGUNTA(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechainipregunta = xMLGregorianCalendar;
    }
}
