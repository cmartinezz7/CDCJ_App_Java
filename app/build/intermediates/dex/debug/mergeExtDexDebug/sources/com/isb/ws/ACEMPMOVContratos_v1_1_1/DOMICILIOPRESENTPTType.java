package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DOMICILIO_PRESENT_PT_Type", propOrder = {"tipovia", "nombrevia", "tipopuerta", "numerovia", "restodomic", "localidad", "codigopostal", "distrito", "concelho", "fregresia", "codigoregion"})
public class DOMICILIOPRESENTPTType {
    @XmlElement(name = "CODIGO_POSTAL", required = true)
    protected String codigopostal;
    @XmlElement(name = "CODIGO_REGION", required = true)
    protected String codigoregion;
    @XmlElement(name = "CONCELHO", required = true)
    protected String concelho;
    @XmlElement(name = "DISTRITO", required = true)
    protected String distrito;
    @XmlElement(name = "FREGRESIA", required = true)
    protected String fregresia;
    @XmlElement(name = "LOCALIDAD", required = true)
    protected String localidad;
    @XmlElement(name = "NOMBRE_VIA", required = true)
    protected String nombrevia;
    @XmlElement(name = "NUMERO_VIA", required = true)
    protected String numerovia;
    @XmlElement(name = "RESTO_DOMIC", required = true)
    protected String restodomic;
    @XmlElement(name = "TIPO_PUERTA", required = true)
    protected String tipopuerta;
    @XmlElement(name = "TIPO_VIA", required = true)
    protected String tipovia;

    public String getTIPOVIA() {
        return this.tipovia;
    }

    public void setTIPOVIA(String str) {
        this.tipovia = str;
    }

    public String getNOMBREVIA() {
        return this.nombrevia;
    }

    public void setNOMBREVIA(String str) {
        this.nombrevia = str;
    }

    public String getTIPOPUERTA() {
        return this.tipopuerta;
    }

    public void setTIPOPUERTA(String str) {
        this.tipopuerta = str;
    }

    public String getNUMEROVIA() {
        return this.numerovia;
    }

    public void setNUMEROVIA(String str) {
        this.numerovia = str;
    }

    public String getRESTODOMIC() {
        return this.restodomic;
    }

    public void setRESTODOMIC(String str) {
        this.restodomic = str;
    }

    public String getLOCALIDAD() {
        return this.localidad;
    }

    public void setLOCALIDAD(String str) {
        this.localidad = str;
    }

    public String getCODIGOPOSTAL() {
        return this.codigopostal;
    }

    public void setCODIGOPOSTAL(String str) {
        this.codigopostal = str;
    }

    public String getDISTRITO() {
        return this.distrito;
    }

    public void setDISTRITO(String str) {
        this.distrito = str;
    }

    public String getCONCELHO() {
        return this.concelho;
    }

    public void setCONCELHO(String str) {
        this.concelho = str;
    }

    public String getFREGRESIA() {
        return this.fregresia;
    }

    public void setFREGRESIA(String str) {
        this.fregresia = str;
    }

    public String getCODIGOREGION() {
        return this.codigoregion;
    }

    public void setCODIGOREGION(String str) {
        this.codigoregion = str;
    }
}
