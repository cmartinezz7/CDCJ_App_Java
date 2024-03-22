package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RESPUESTA_VALCOR_Type", propOrder = {"empresa", "idcuestionariovalcor", "idrespuestavalcor", "fechainirespuesta"})
public class RESPUESTAVALCORType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_INI_RESPUESTA", required = true)
    protected XMLGregorianCalendar fechainirespuesta;
    @XmlElement(name = "ID_CUESTIONARIO_VALCOR", required = true)
    protected String idcuestionariovalcor;
    @XmlElement(name = "ID_RESPUESTA_VALCOR", required = true)
    protected String idrespuestavalcor;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getIDCUESTIONARIOVALCOR() {
        return this.idcuestionariovalcor;
    }

    public void setIDCUESTIONARIOVALCOR(String str) {
        this.idcuestionariovalcor = str;
    }

    public String getIDRESPUESTAVALCOR() {
        return this.idrespuestavalcor;
    }

    public void setIDRESPUESTAVALCOR(String str) {
        this.idrespuestavalcor = str;
    }

    public XMLGregorianCalendar getFECHAINIRESPUESTA() {
        return this.fechainirespuesta;
    }

    public void setFECHAINIRESPUESTA(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechainirespuesta = xMLGregorianCalendar;
    }
}
