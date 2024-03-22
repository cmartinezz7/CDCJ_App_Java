package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COLUMNA_AYUDA_VALCOR_Type", propOrder = {"empresa", "areavalcor", "valorminvalcor", "fechainiayuda"})
public class COLUMNAAYUDAVALCORType {
    @XmlElement(name = "AREA_VALCOR", required = true)
    protected String areavalcor;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_INI_AYUDA", required = true)
    protected XMLGregorianCalendar fechainiayuda;
    @XmlElement(name = "VALOR_MIN_VALCOR", required = true)
    protected BigDecimal valorminvalcor;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getAREAVALCOR() {
        return this.areavalcor;
    }

    public void setAREAVALCOR(String str) {
        this.areavalcor = str;
    }

    public BigDecimal getVALORMINVALCOR() {
        return this.valorminvalcor;
    }

    public void setVALORMINVALCOR(BigDecimal bigDecimal) {
        this.valorminvalcor = bigDecimal;
    }

    public XMLGregorianCalendar getFECHAINIAYUDA() {
        return this.fechainiayuda;
    }

    public void setFECHAINIAYUDA(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechainiayuda = xMLGregorianCalendar;
    }
}
