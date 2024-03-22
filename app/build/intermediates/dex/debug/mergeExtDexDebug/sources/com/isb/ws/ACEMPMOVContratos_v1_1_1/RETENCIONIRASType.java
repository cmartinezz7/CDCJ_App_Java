package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RETENCION_IRAS_Type", propOrder = {"empresa", "conceptofiscal", "codigodeterritorio"})
public class RETENCIONIRASType {
    @XmlElement(name = "CODIGO_DE_TERRITORIO", required = true)
    protected String codigodeterritorio;
    @XmlElement(name = "CONCEPTO_FISCAL", required = true)
    protected String conceptofiscal;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCONCEPTOFISCAL() {
        return this.conceptofiscal;
    }

    public void setCONCEPTOFISCAL(String str) {
        this.conceptofiscal = str;
    }

    public String getCODIGODETERRITORIO() {
        return this.codigodeterritorio;
    }

    public void setCODIGODETERRITORIO(String str) {
        this.codigodeterritorio = str;
    }
}
