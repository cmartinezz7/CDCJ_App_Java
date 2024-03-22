package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRITERIO_ESTRA_UNIDAD_AIS_Type", propOrder = {"empresa", "tipocriterioestra", "seccriterioestraunidad"})
public class CRITERIOESTRAUNIDADAISType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "SEC_CRITERIO_ESTRA_UNIDAD")
    protected int seccriterioestraunidad;
    @XmlElement(name = "TIPO_CRITERIO_ESTRA", required = true)
    protected String tipocriterioestra;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPOCRITERIOESTRA() {
        return this.tipocriterioestra;
    }

    public void setTIPOCRITERIOESTRA(String str) {
        this.tipocriterioestra = str;
    }

    public int getSECCRITERIOESTRAUNIDAD() {
        return this.seccriterioestraunidad;
    }

    public void setSECCRITERIOESTRAUNIDAD(int i) {
        this.seccriterioestraunidad = i;
    }
}
