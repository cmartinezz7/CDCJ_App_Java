package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REMESA_COMPENSACION_Type", propOrder = {"centro", "fecharemesa", "refremesa"})
public class REMESACOMPENSACIONType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_REMESA", required = true)
    protected XMLGregorianCalendar fecharemesa;
    @XmlElement(name = "REF_REMESA", required = true)
    protected String refremesa;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public XMLGregorianCalendar getFECHAREMESA() {
        return this.fecharemesa;
    }

    public void setFECHAREMESA(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fecharemesa = xMLGregorianCalendar;
    }

    public String getREFREMESA() {
        return this.refremesa;
    }

    public void setREFREMESA(String str) {
        this.refremesa = str;
    }
}
